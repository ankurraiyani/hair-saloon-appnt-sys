package com.SalonSphereServer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SalonSphereServer.dto.CustomerDTO;
import com.SalonSphereServer.entity.ShopInformation;
import com.SalonSphereServer.entity.Users;
import com.SalonSphereServer.repository.ShopkeeperRepository;
import com.SalonSphereServer.repository.UserRepository;
import com.SalonSphereServer.request.FilterRequest;
import com.SalonSphereServer.response.FilterResponse;
import com.SalonSphereServer.response.FilterResponseByCity;

@Service
public class CustomerService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ShopkeeperRepository shopkeeperRepository;

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

	// ===========================================================================================================

	// Throuhg this method we filter on city
	public List<FilterResponseByCity> filterByCity(String city) {

		System.out.println("+++++++Inside Customer Service FilterByCity++++++++++" + city);

		List<ShopInformation> shops = shopkeeperRepository.findShopByCity(city);
		if (shops != null) {
			List<FilterResponseByCity> filterResponse = new ArrayList<>();
			for (ShopInformation s : shops) {
				FilterResponseByCity fResponse = new FilterResponseByCity();

				fResponse.setShopName(s.getShopName());
				fResponse.setLocation(
						s.getAddress() + " " + s.getLandmark() + " " + s.getState());
				fResponse.setCoverImage(s.getCoverImage());
				filterResponse.add(fResponse);
			}
			return filterResponse;
		}
		return null;
	}

	// ===========================================================================================================
	// Throuhg this method we filter on city,serviceName,priceRange(100-200) and distanceRange (5-10).Distance always in meter
	public List<FilterResponse> filterByCityAndServiceNameAndServicePriceAndDistance(FilterRequest request) {

		int minPrice, maxPrice;
		int minDistance, maxDistance;
		if (request.getServiceName() == null) {
		}
		if (request.getPrice() == null) {

			minPrice = 0;
			maxPrice = 100000;
		} else {

			String priceRange[] = request.getPrice().split("-");
			minPrice = Integer.parseInt(priceRange[0].trim());
			maxPrice = Integer.parseInt(priceRange[1].trim());

		}
		if (request.getDistance() == null) {
			minDistance = 0;
			maxDistance = 10000000;
		} else {
			String distanceRange[] = request.getDistance().split("-");
			minDistance = Integer.parseInt(distanceRange[0].trim());
			maxDistance = Integer.parseInt(distanceRange[1].trim());
		}

		List<Object[]> shops = shopkeeperRepository.findShopByCityAndServiceNameAndServicePriceAndDistance(
				request.getCity(), request.getServiceName(), minPrice, maxPrice, minDistance, maxDistance);

		List<FilterResponse> responseList = new ArrayList<>();
		for (Object[] obj : shops) {
			FilterResponse filterResponse = new FilterResponse();
			filterResponse.setShopName((String) obj[0]);
			filterResponse.setServiceName((String) obj[1]);
			double price1 = (double) obj[2];
			// Explicit type casting double to int
			int roundedPrice = (int) price1;
			filterResponse.setServicePrice(roundedPrice);
			filterResponse.setServiceDuration((int) obj[3]);
			responseList.add(filterResponse);
		}
		return responseList;
	}
}
