package com.SalonSphereServer.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SalonSphereServer.entity.Slots;
import com.SalonSphereServer.repository.SlotRepository;
import com.SalonSphereServer.request.SlotBookingRequest;

@Service
public class SlotBookingService {
	
	@Autowired
	private SlotRepository slotRepository;
	
	public boolean bookSlot(SlotBookingRequest request) {
		
		Slots slot = new Slots();
		slot.setBookingId(UUID.randomUUID().toString());
		String dateString = request.getDate();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		//convert the date into the Java util date
		
		try {
			Date date = simpleDateFormat.parse(dateString);
			slot.setBookingDate(date);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		
	
		slot.setEmployeeId(request.getEmpId());
		slot.setServiceName(request.getServiceName());
		slot.setSlotDuration(request.getServiceTime());
		slot.setSlotTime(request.getSlotTime());
		
		return slotRepository.save(slot)!=null;
	}

}
