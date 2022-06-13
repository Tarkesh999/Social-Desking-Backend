package com.Gettintogether.service;

import com.Gettintogether.model.Booking;
import com.Gettintogether.model.Desk;

import java.util.List;

public interface IDeskService {
	
	List<Desk> listAllDesks();
	
	Desk findDeskById(Long deskId);
	
	List<Desk> findDesksByBuilding(String building);
	
	List<Desk> findDeskListByLocation(String building, int floorNo);
	
    Desk findDeskByLocation(String building, int floorNo, int deskNo);
    
    Desk saveDesk(Desk desk)throws Exception;
}
