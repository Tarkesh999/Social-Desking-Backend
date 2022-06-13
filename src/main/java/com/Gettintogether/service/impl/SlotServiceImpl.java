package com.Gettintogether.service.impl;

import com.Gettintogether.model.Slot;
import com.Gettintogether.repository.SlotRepository;
import com.Gettintogether.service.ISlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class SlotServiceImpl implements ISlotService {

    @Autowired
    SlotRepository slotRepository;

	@Override
	public List<Slot> listAllSlots() {
		return slotRepository.findAll();
	}

    @Override
    public Slot findSlotBySlotId(Long slotId) {
        return slotRepository.findBySlotId(slotId);
    }

    @Override
    public List<Slot> findSlotsByDate(Date date) {
        return slotRepository.findSlotByDate(date);
    }

    @Override
    public List<Slot> findSlotByDeskId(Long deskId) {
        return slotRepository.findSlotByDeskId(deskId);
    }

    @Override
    public List<Slot> findSlotsByStatus(String status) {
        return slotRepository.findSlotByStatus(status);
    }

	@Override
	public void save(Slot slot) {
		// TODO Auto-generated method stub
		slotRepository.save(slot);
	}

	

    
}
