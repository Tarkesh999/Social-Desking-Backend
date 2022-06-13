package com.Gettintogether.facade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gettintogether.dto.UserBookingDTO;
import com.Gettintogether.model.Slot;
import com.Gettintogether.model.User;
import com.Gettintogether.service.IUserService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/userBooking")
public class FacadeController {
	@Autowired
    UserBookingFacade userBookingFacade;
	
	@Autowired
	FloorPlanFacade floorPlanFacade;
	
	@Autowired
	IUserService usi;
	
	@Autowired
	AdminFacade adminFacade;
	
    @GetMapping("/bookings/{email}")
    public ResponseEntity<List<UserBookingDTO>> getBookingsByEmail(@PathVariable("email") String email){
        try{
            return new ResponseEntity<List<UserBookingDTO>>(userBookingFacade.findBookingByEmail(email), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<List<UserBookingDTO>>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/all")
    List<UserBookingDTO> findAll(){
    	List<User> users = usi.findAllUsers();
    	List<UserBookingDTO> userBookings = new ArrayList<>();
    	for(User user : users) {
    		 userBookings.addAll( userBookingFacade.findBookingByEmail(user.getUserEmail()));
    	}
    	return userBookings;
    }
    
    
    
    @GetMapping("/floorPlan/date/{date}/building/{building}/floorNo/{floorNo}")
    	public ResponseEntity<List<Slot>> getFloorPlan(@PathVariable("date") Date date, @PathVariable("building") String building, @PathVariable("floorNo") int floorno ){
    		try {
    			return new ResponseEntity<List<Slot>>(floorPlanFacade.getFloorPlan(date, building, floorno), HttpStatus.OK);
			} 
    		catch (Exception e) {
    			return new ResponseEntity<List<Slot>>(HttpStatus.BAD_REQUEST);
				
			}

    } 
    
    @CrossOrigin(origins="*")
    @GetMapping("admin/date/{date}/building/{building}/floorNo/{floorNo}/mode/{mode}")
    public ResponseEntity<?> updateStatus(@PathVariable("date") Date date, @PathVariable("building") String building, @PathVariable("floorNo") int floorno, @PathVariable("mode") int mode) {
        try {
            adminFacade.adminUpdateSlot(date, building, floorno, mode);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
    
   

