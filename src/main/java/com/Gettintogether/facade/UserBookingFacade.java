package com.Gettintogether.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Gettintogether.dto.UserBookingDTO;
import com.Gettintogether.model.Booking;
import com.Gettintogether.model.Desk;
import com.Gettintogether.model.Slot;
import com.Gettintogether.service.IBookingService;
import com.Gettintogether.service.IDeskService;
import com.Gettintogether.service.ISlotService;

@Component
public class UserBookingFacade {

	@Autowired
	IBookingService bsi;
	@Autowired 
	ISlotService ssi;
	@Autowired
	IDeskService dsi;
	
	public List<UserBookingDTO> findBookingByEmail(String emailId){
		List<Booking> listOfBookings = bsi.findBookingByEmail(emailId);
		List<UserBookingDTO> listOfUserBookingDTO = new ArrayList<>();
		for(Booking booking: listOfBookings) {
			Long slotId = booking.getSlotId();
			Slot uslot= ssi.findSlotBySlotId(slotId);
			Long deskId = uslot.getDeskId();
			Desk udesk  = dsi.findDeskById(deskId);
			UserBookingDTO ubd= new UserBookingDTO();
			ubd.setTransactionId(booking.getTransactionId());
			ubd.setEmailId(booking.getEmailId());
			ubd.setSlotDate(uslot.getSlotDate());
			ubd.setBuilding(udesk.getBuilding());
			ubd.setFloorNo(udesk.getFloorNo());
			ubd.setDeskNo(udesk.getDeskNo());
			listOfUserBookingDTO.add(ubd);
			}
		return listOfUserBookingDTO;			
	}		
}
	
	


