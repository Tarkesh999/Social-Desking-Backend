package com.Gettintogether.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Gettintogether.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
  
	@Query("SELECT b FROM Booking b WHERE b.emailId =:e")
	public List<Booking> listBookingByEmail(@Param("e")String emailId);
	
}