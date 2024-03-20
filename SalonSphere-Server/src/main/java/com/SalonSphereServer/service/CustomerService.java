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

	// Throuhg this method we filter on service name and city
	public List<FilterResponse> filterByServiceNameAndCity(String typeOfService, String city) {
		List<Object[]> shops = shopkeeperRepository.findShopByCityAndSeviceName(city, typeOfService);
		List<FilterResponse> responseList = new ArrayList<>();
		for (Object[] obj : shops) {
			FilterResponse filterResponse = new FilterResponse();
			filterResponse.setShopName((String) obj[0]);
			filterResponse.setServiceName((String) obj[1]);
			double price = (double) obj[2];
			// Explicit type casting double to int
			int roundedPrice = (int) price;
			filterResponse.setServicePrice(roundedPrice);
			filterResponse.setServiceDuration((int) obj[3]);
			responseList.add(filterResponse);
		}
		return responseList;
	}

	// ==============================================================================================================

	// Throuhg this method we filter on city,service name and priceRange(100-200)
	public List<FilterResponse> filterByCityAndServiceNameAndServicePrice(String city, String serviceName,
			String price_Range) {

		// Split the
		String priceRange[] = price_Range.split("-");
		int priceMin = Integer.parseInt(priceRange[0].trim());
		int priceMax = Integer.parseInt(priceRange[1].trim());

		List<Object[]> shops = shopkeeperRepository.findShopByCityAndServiceNameAndServicePrice(city, serviceName,
				priceMin, priceMax);
		List<FilterResponse> responseList = new ArrayList<>();
		for (Object[] obj : shops) {
			FilterResponse filterResponse = new FilterResponse();
			filterResponse.setShopName((String) obj[0]);
			filterResponse.setServiceName((String) obj[1]);
			double price = (double) obj[2];
			// Explicit type casting double to int
			int roundedPrice = (int) price;
			filterResponse.setServicePrice(roundedPrice);
			filterResponse.setServiceDuration((int) obj[3]);
			responseList.add(filterResponse);
		}
		return responseList;
	}

	// ==============================================================================================================

	// Throuhg this method we filter on city,serviceName,priceRange(100-200) and distanceRange (5-10).Distance always in meter
	public List<FilterResponse> filterByCityAndServiceNameAndServicePriceAndDistance(String city, String serviceName,String price,String distance) {

		// Split the priceRange
		String priceRange[] = price.split("-");
		int priceMin = Integer.parseInt(priceRange[0].trim());
		int priceMax = Integer.parseInt(priceRange[1].trim());

		// Split the distanceRange
		String distanceRange[] = distance.split("-");
		int distanceMin = Integer.parseInt(distanceRange[0].trim());
		int distanceMax = Integer.parseInt(distanceRange[1].trim());

		List<Object[]> shops = shopkeeperRepository.findShopByCityAndServiceNameAndServicePriceAndDistance(city, serviceName, priceMin, priceMax, distanceMin, distanceMax);
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
