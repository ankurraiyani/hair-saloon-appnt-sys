package com.SalonSphereServer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SalonSphereServer.dto.CustomerDTO;
import com.SalonSphereServer.entity.Users;
import com.SalonSphereServer.repository.ShopEmployeeRepository;
import com.SalonSphereServer.repository.SlotRepository;
import com.SalonSphereServer.repository.UserRepository;

@Service
public class CustomerService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ShopEmployeeRepository shopEmployeeRepository;

	@Autowired
	private SlotRepository slotRepository;

	// call the userRepository method and fetch all the customer data from database
	public List<CustomerDTO> getAllCustomers() {

		System.out.println("come inside the services method");
		List<Users> users = userRepository.findByRole("customer");

		List<CustomerDTO> cutomers = new ArrayList<CustomerDTO>();

		for (int i = 0; i < users.size(); i++) {

			Users user = users.get(i);
			cutomers.add(new CustomerDTO(user.getFirstName() + " " + user.getLastName(), user.getEmail(),
					user.getContactNumber()));
		}
		return cutomers;
	}

	public Map<String, List<String>> getAllSlots(String shopId, String shopTiming, int serviceTime) {

		List<Object[]> shopEmployees = shopEmployeeRepository.findShopEmplooyesByShopId(shopId);

		Map<String, List<String>> avilableSlots = new HashMap<String, List<String>>();

		for (Object[] employeeData : shopEmployees) {

			String employeeName = (String) employeeData[1];
			String employeeId = (String) employeeData[0];

			List<String> bookedSlots = slotRepository.findAllSlotTimeByEmployeeId(employeeId);

			List<String> list = geeAllAbilableSlots(serviceTime, bookedSlots, shopTiming);
			avilableSlots.put(employeeName, list);
		}

		return avilableSlots;
	}

	public List<String> geeAllAbilableSlots(int serviceTime, List<String> bookedSlots, String shopTiming) {

		List<String> avilableSlots = new ArrayList<String>();

		// Set the opening time
		
		int openingTime = Integer.parseInt(""+shopTiming.charAt(0)+shopTiming.charAt(1));
		int startMinute = Integer.parseInt(""+shopTiming.charAt(3)+shopTiming.charAt(4));
		int endMinute = Integer.parseInt(""+shopTiming.charAt(9)+shopTiming.charAt(10));
		// Set the closing time
		int closingTime = Integer.parseInt(""+shopTiming.charAt(6)+shopTiming.charAt(7));

		// Convert opening time to total minutes
		int totalMinutes = openingTime * 60 + startMinute;

		while ((totalMinutes + serviceTime) <= closingTime * 60+endMinute) {
			// Calculate end time
			int endHourSlot = (totalMinutes + serviceTime) / 60;
			int endMinuteSlot = (totalMinutes + serviceTime) % 60;

			// Format start and end time strings
			String startSlot = String.format("%02d:%02d", totalMinutes / 60, totalMinutes % 60);
			String endSlot = String.format("%02d:%02d", endHourSlot, endMinuteSlot);

			// Check if the slot is already booked
			boolean isBooked = false;
			String currentSlot = startSlot + "-" + endSlot;
			for (String bookedSlot : bookedSlots) {
				if (isOverlap(currentSlot, bookedSlot)) {
					isBooked = true;
					break;
				}
			}

			// Add the slot to the list if not booked
			if (!isBooked) {
				avilableSlots.add(currentSlot);
			}

			// Move to the next slot
			totalMinutes += serviceTime;
		}
		return avilableSlots;

	}

	// Helper method to check if two time slots overlap
	public static boolean isOverlap(String slot1, String slot2) {
		String[] parts1 = slot1.split("-");
		String[] parts2 = slot2.split("-");

		String[] startTime1 = parts1[0].split(":");
		String[] endTime1 = parts1[1].split(":");
		String[] startTime2 = parts2[0].split(":");
		String[] endTime2 = parts2[1].split(":");

		int startHour1 = Integer.parseInt(startTime1[0]);
		int startMinute1 = Integer.parseInt(startTime1[1]);
		int endHour1 = Integer.parseInt(endTime1[0]);
		int endMinute1 = Integer.parseInt(endTime1[1]);
		int startHour2 = Integer.parseInt(startTime2[0]);
		int startMinute2 = Integer.parseInt(startTime2[1]);
		int endHour2 = Integer.parseInt(endTime2[0]);
		int endMinute2 = Integer.parseInt(endTime2[1]);

		int start1 = startHour1 * 60 + startMinute1;
		int end1 = endHour1 * 60 + endMinute1;
		int start2 = startHour2 * 60 + startMinute2;
		int end2 = endHour2 * 60 + endMinute2;

		return !(end1 <= start2 || start1 >= end2);
	}

	public static int extractOpeningTime(String shopTiming) {
		String[] parts = shopTiming.split("-");
		String openingTimeStr = parts[0];
		String[] timeParts = openingTimeStr.split(":");
		return Integer.parseInt(timeParts[0]);
	}

	public static int extractClosingTime(String shopTiming) {
		String[] parts = shopTiming.split("-");
		String closingTimeStr = parts[1];
		String[] timeParts = closingTimeStr.split(":");
		return Integer.parseInt(timeParts[0]);
	}

}
