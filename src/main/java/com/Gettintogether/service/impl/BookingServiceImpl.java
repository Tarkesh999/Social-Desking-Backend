package com.Gettintogether.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gettintogether.dto.UserBookingDTO;
import com.Gettintogether.facade.UserBookingFacade;
import com.Gettintogether.model.Booking;
import com.Gettintogether.model.Slot;
import com.Gettintogether.repository.BookingRepository;
import com.Gettintogether.service.IBookingService;


@Service
public class BookingServiceImpl implements IBookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	UserBookingFacade userBookingFacade;
	
	@Autowired
	SlotServiceImpl slotServiceImpl;
	
	@Override
	public Booking saveBooking(Booking booking) throws Exception {
		List<UserBookingDTO> userBookings = userBookingFacade.findBookingByEmail(booking.getEmailId());
		Long slotId = booking.getSlotId();
		Slot slot = slotServiceImpl.findSlotBySlotId(slotId);
		Date date = slot.getSlotDate();
		
		for(UserBookingDTO ubd: userBookings) {
			if(ubd.getSlotDate().equals(date)) {
				throw new Exception("User Booking exists on this date!");
			}
		}
		
		slot.setStatus("BOOKED");
		slotServiceImpl.save(slot);

		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> findBookingByEmail(String email) {
		return bookingRepository.listBookingByEmail(email);

	}

	@Override
	public List<Booking> findAll() {
		return bookingRepository.findAll();
	}

	@Override
	public Booking insertBooking(Booking booking) throws Exception {
		return bookingRepository.save(booking);
	}

	

 }

