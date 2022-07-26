package com.flightadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightadmin.model.Admin;
import com.flightadmin.repo.AdminRepository;
import com.google.common.base.Optional;

@RestController
public class AdminController {
	@Autowired
	private AdminRepository repository;
	
	/*
	 * @Autowired private RestTemplate restTemplate;
	 */
	@PostMapping("/addFlight")
	public String saveBook(@RequestBody Admin admin) {
		repository.save(admin);
		return "Added Flight with id : " + admin.getFlightid();
	}

	@GetMapping("/getAllFlights")
	public List<Admin> getBooks() {
		return (List<Admin>) repository.findAll();
	}
	
	
	

	@GetMapping("/getAllFlights/{flight_id}")
	public java.util.Optional<Admin> getTrainName(@PathVariable("flight_id") String flight_id) {
		return repository.findById(flight_id);
	}

	@DeleteMapping("/delete/{flight_id}")
	public String deleteFlight (@PathVariable String flightid) {
		repository.deleteById(flightid);
		return "Flight deleted with no : "+flightid;
	 
	}
	
	@PutMapping("/update/{flight_id}")
	public Admin updateFlight(@PathVariable("flightid") String flightid,@RequestBody Admin t ) {
		t.setFlight_no(flightid);
		repository.save(t);
		return t;
}
}
	


