package com.SalonSphereServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SalonSphereServer.entity.Feedback;
import com.SalonSphereServer.repository.FeedbackRepository;
import com.SalonSphereServer.request.FilterRequest;
import com.SalonSphereServer.response.FilterResponse;
import com.SalonSphereServer.response.FilterResponseByCity;
import com.SalonSphereServer.response.Response;
import com.SalonSphereServer.service.CustomerService;
import com.SalonSphereServer.service.FeedbackService;

// This is Shopkeerper related  controller class  for handling shopkeeper related API
@RestController
@CrossOrigin(origins = "http://localhost:4200")
// @RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private FeedbackService feedbackService;
	@Autowired
	private FeedbackRepository feedbackRepository;

	// ============================================================================================================
	// Filter shops by given city
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/filter-by-city/{city}")
	public ResponseEntity<List<FilterResponseByCity>> filterByCity(@PathVariable String city) {

		System.out.println("====Inside the customer Controller in filterByCity===\n" + city);

		// wriet code for fiter according to city
		List<FilterResponseByCity> filterResponse = customerService.filterByCity(city);
		if (filterResponse != null)
			return ResponseEntity.ok().body(filterResponse);
		else
			return new ResponseEntity<>(filterResponse, HttpStatus.NOT_FOUND);
	}

	// ==============================================================================================================

	// Filtering based on servicename, serviceprice and distance
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/filter-shop")
	public ResponseEntity<List<FilterResponse>> filterShop(@RequestBody FilterRequest request) {

		System.out.println("====Inside the customer Controller in filtershop===\n" + request);
		// here we are checking whether all fields of FilterRequest are empty or not
		if (request.getServiceName() != null && request.getDistance() == null && request.getPrice() == null) {
			// here we calling a methodn from customerservoce which is
			// filterByServiceNameAndCity
			System.out.println("++++INSIDE THE CITY AND SERVICENAME FILLER IF CONDITION++++\n");
			List<FilterResponse> filterRespons = customerService.filterByServiceNameAndCity(request.getServiceName(),
					request.getCity());

			// here we check filterResponse is empty or not
			if (!filterRespons.isEmpty())
				return ResponseEntity.ok().body(filterRespons);
			else
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		} else if (request.getServiceName() != null && request.getPrice() != null && request.getDistance() == null) {
			// write code for filtering by category for service name and city

			System.out.println("++++INSIDE THE CITY,SERVICENAME AND SERVICEPRICERANGE FILLER ELSE IF CONDITION++++\n");
			List<FilterResponse> filterRespons = customerService.filterByCityAndServiceNameAndServicePrice(
					request.getCity(), request.getServiceName(), request.getPrice());

			System.out.println("++++++Return++++\n" + filterRespons);
			// here we check filterResponse is empty or not
			if (!filterRespons.isEmpty())
				return ResponseEntity.ok().body(filterRespons);
			else
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {

			System.out.println(
					"+++INSIDE THE CITY,SERVICENAME,SERVICEPRICERANGE AND DISTANCERANGE FILLER ELSE IF CONDITION++++\n");

			// write code for filtering by category for service name , city , price range
			// and distance
			List<FilterResponse> filterRespons = customerService.filterByCityAndServiceNameAndServicePriceAndDistance(
					request.getCity(), request.getServiceName(), request.getPrice(), request.getDistance());

			// here we check filterResponse is empty or not
			if (!filterRespons.isEmpty())
				return ResponseEntity.ok().body(filterRespons);
			else
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	// ================CODE FOR FEEDBACK/REVIEW/RATING===========================
	// Through this method the user can give feedback to the provider
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/feedback")
	public ResponseEntity<Response> addFeedBack(@RequestBody Feedback feedback) {

		System.out.println("=====INSIDE THE COUSTOMERCONTROLLER ADDFEEDBACK======\n" + feedback);
		boolean isAdd = feedbackService.addFeedBack(feedback);
		if (isAdd)
			return ResponseEntity.ok().body(new Response("Review added Successfully"));
		else
			return ResponseEntity.badRequest().body(new Response("Review not added"));
	}

	// Through this controller we get all leatest feedback in deasending order by
	// date from the database by shopid
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/get-all-feedback/{shopId}")
	public ResponseEntity<List<Feedback>> getAllFeedbackByShopId(@PathVariable String shopId) {

		System.out.println("=====INSIDE THE COUSTOMERCONTROLLER getAllFeedbackByShopId======\n" + shopId);
		List<Feedback> fList = feedbackRepository.findByShopIdOrderByReviewDateDesc(shopId);
		if (!fList.isEmpty())
			return ResponseEntity.ok().body(fList);
		else
			return ResponseEntity.badRequest().body(fList);
	}

	// This API's is used for getting values of likes by review_id
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/likes-by-reviewid/{reviewId}")
	public ResponseEntity<Response> getLikesByReviewId(@PathVariable int reviewId) {
		System.out.println("=====INSIDE THE COUSTOMERCONTROLLER getLikesByReviewId======\n" + reviewId);
		return ResponseEntity.ok().body(new Response("" + feedbackRepository.findLikesByReviewId(reviewId)));
	}

	// This API's is used for updating likes value by 1 with the help of review_id
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/like-by-ince")
	public ResponseEntity<Response> incrementLikeByReviewId(@PathVariable int reviewId, @PathVariable int like) {
		System.out.println(
				"=====INSIDE THE COUSTOMERCONTROLLER  incrementLikeByReviewId======\n" + reviewId + "," + like);
		feedbackRepository.updateLikesByReviewId(like, reviewId);
		return ResponseEntity.ok().body(new Response("Like Increment By 1."));
	}

	// This API's is used for updating likes value by -1 with the help of review_id
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/like-by-desc")
	public ResponseEntity<Response> decrementLikeByReviewId(@PathVariable int reviewId, @PathVariable int like) {
		System.out.println(
				"=====INSIDE THE COUSTOMERCONTROLLER  incrementLikeByReviewId======\n" + reviewId + "," + like);
		feedbackRepository.updateLikesByReviewId(like, reviewId);
		return ResponseEntity.ok().body(new Response("Like decrement By -1."));
	}

	// This API's is used for updating likes value by -1 with the help of review_id
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/delete-review/{reviewId}")
	public ResponseEntity<Response> deleteReviewId(@PathVariable int reviewId) {
		System.out.println("=====INSIDE THE COUSTOMERCONTROLLER  deleteReviewId======\n" + reviewId);
		feedbackRepository.deleteById(reviewId);
		return ResponseEntity.ok().body(new Response("Review Deleted Succeefully"));
	}
}