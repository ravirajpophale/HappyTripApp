package com.myapp.happytrip.api;

import java.sql.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.happytrip.model.Booking;
import com.myapp.happytrip.repository.BookingList;

@RestController
@RequestMapping("/api/v1/bookingdetails")
public class BookingAPI extends TravellerDetailsAPI {

	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private BookingList booking;

	@GetMapping("passenger/{firstName}")
	public ResponseEntity<List<Booking>> findByFirstName(@PathVariable("firstName") String name) {

			String bookingId = passengerId + flightId;
			System.out.println(bookingId + firstName + lastName + flightName + flightId + departureLoc + departureD
					+ arrivalLoc + arrivalD);
			
			String query = "INSERT INTO booking(BOOKING_ID, FIRST_NAME, LAST_NAME,FLIGHT_NAME, FLIGHT_ID, DEPARTURE_LOCATION, DEPARTURE_DATE, ARRIVAL_LOCATION, ARRIVAL_DATE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		 template.update(query,bookingId,firstName,lastName,flightName,flightId,departureLoc,departureD,arrivalLoc,arrivalD);
			

		
		return new ResponseEntity<List<Booking>>(booking.findByfirstName(name).get(), HttpStatus.OK);
	}

}
