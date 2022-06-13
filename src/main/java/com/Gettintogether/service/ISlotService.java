package com.Gettintogether.service;

import com.Gettintogether.model.Slot;

import java.sql.Date;
import java.util.List;

public interface ISlotService {

	List<Slot> listAllSlots();
	
    Slot findSlotBySlotId(Long slotId);

    List<Slot> findSlotsByDate(Date date);

    List<Slot> findSlotByDeskId(Long deskId);

    List<Slot> findSlotsByStatus(String status);

	void save(Slot slot);
	
}
