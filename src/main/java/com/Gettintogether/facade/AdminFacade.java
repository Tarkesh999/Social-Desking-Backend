package com.Gettintogether.facade;

import com.Gettintogether.model.Desk;
import com.Gettintogether.model.Slot;
import com.Gettintogether.service.IDeskService;
import com.Gettintogether.service.ISlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AdminFacade {
	
    @Autowired
    IDeskService dsi;
    
    @Autowired
    ISlotService ssi;

    public void adminUpdateSlot(Date date, String building, int floorNo, int mode){
    	//enable all, disable all, social-dist
        List<Slot> listOfSlots = ssi.findSlotsByDate(date);
        Map<Long, Slot> mapOfDesk= new HashMap<>();
        for(Slot slot : listOfSlots) {
        	slot.setStatus("AVAILABLE");
            mapOfDesk.put(slot.getDeskId(),slot);
            ssi.save(slot);
        }
        List<Desk> desksOnFloor=dsi.findDeskListByLocation(building, floorNo);
        
        if(mode == 0) return;
        
        for(Desk desk: desksOnFloor){
            Long deskid = desk.getDeskId();
            Slot slot = mapOfDesk.get(deskid);
            
            if(mode == 1) {
            	slot.setStatus("DISABLED");
            }
            
            if(mode == 2 && desk.getDeskNo()%2 == 0) {
            	slot.setStatus("DISABLED");
            }
            
            ssi.save(slot);
        }
    }
}
