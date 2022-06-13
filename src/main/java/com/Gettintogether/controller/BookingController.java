/**
 * @author Rashika
 */

package com.Gettintogether.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gettintogether.model.Booking;
import com.Gettintogether.model.Slot;
import com.Gettintogether.service.IBookingService;
import com.Gettintogether.service.ISlotService;
import com.Gettintogether.utils.Utils;

@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins="*")
public class BookingController {

	private static final String TAG = "Booking Controller";
	
	@Autowired
	IBookingService bsi;

	@Autowired
	ISlotService slotService;


	@PostMapping("/booking")
	@CrossOrigin(origins="*")
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking  ){
		try {
			Slot slot = slotService.findSlotBySlotId(booking.getSlotId());
			if(slot == null || !slot.getStatus().equals("AVAILABLE"))
				throw new IllegalArgumentException(Utils.getErrorMessageFromKey(TAG, "slotError"));
			Booking newbooking= bsi.saveBooking(booking);
			newbooking.setCreatedAt(Timestamp.from(Instant.now()));

			return new ResponseEntity<Booking>(newbooking, HttpStatus.OK);
		}
		catch(Exception e){
			e.printStackTrace();
			if(e.getMessage().equals("User Booking exists on this date!"))
				return new ResponseEntity<Booking>(HttpStatus.NOT_MODIFIED);
			else
				return new ResponseEntity<Booking>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	 @GetMapping("/{email}")
	    public ResponseEntity<List<Booking>> getBookingByEmail(@PathVariable("email") String email) {
	        try {
	            return new ResponseEntity<List<Booking>>(bsi.findBookingByEmail(email), HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);
	        }
	    }
    
    @PostMapping("/postGetBooking")
    public ResponseEntity insertBooking(@RequestBody Booking booking){
    	try {
			bsi.insertBooking(booking);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
    }
    
}
