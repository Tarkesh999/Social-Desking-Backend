package com.Gettintogether.service;

import com.Gettintogether.model.Booking;

import java.util.List;

public interface IBookingService {
    Booking saveBooking(Booking booking)throws Exception;

    List<Booking> findBookingByEmail(String email);
     
    List<Booking> findAll();
    
    Booking insertBooking(Booking booking)throws Exception;
}
