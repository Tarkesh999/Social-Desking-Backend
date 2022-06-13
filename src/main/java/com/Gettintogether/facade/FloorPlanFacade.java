package com.Gettintogether.facade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Gettintogether.model.Desk;
import com.Gettintogether.model.Slot;
import com.Gettintogether.service.IDeskService;
import com.Gettintogether.service.ISlotService;

@Component
public class FloorPlanFacade {
	
	@Autowired 
	ISlotService ssi;
	@Autowired
	IDeskService dsi;
	
	public List<Slot> getFloorPlan(Date date, String building, int floorNo){
		List<Slot> listOfSlots = ssi.findSlotsByDate( date);
		Map<Long, Slot> mapOfDeskStatus= new HashMap<>();
		for(Slot slot : listOfSlots) {
			mapOfDeskStatus.put(slot.getDeskId(),slot);			
		}
		List<Desk> desksOnFloor=dsi.findDeskListByLocation(building, floorNo);
		List<Slot> deskStatus = new ArrayList<>();
		for(Desk desk: desksOnFloor) {
			Long deskid = desk.getDeskId();
			deskStatus.add(( mapOfDeskStatus).get(deskid));
		}
		return deskStatus;
		
	}

}
