package com.Gettintogether.service.impl;

import com.Gettintogether.model.Desk;
import com.Gettintogether.repository.DeskRepository;
import com.Gettintogether.service.IDeskService;
import com.Gettintogether.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeskServiceImpl implements IDeskService {

    private static final String TAG = "DeskService";

    @Autowired
    private DeskRepository deskRepository;

    @Override
    public Desk findDeskById(Long deskId) {
        
        Utils.checkDeskIDValidity(TAG, deskId);

        return deskRepository.findByDeskId(deskId);
    }

    
    @Override
    public Desk findDeskByLocation(String building, int floorNo, int deskNo) {

        Utils.checBuildingkValidity(TAG, building);
        
        Utils.checkFloorValidity(TAG, floorNo);

        Utils.checkDeskNoValidity(TAG, deskNo);

        return deskRepository.findByDeskLocation(building, floorNo, deskNo);
    }

    @Override
    public List<Desk> findDeskListByLocation(String building, int floorNo) {

        Utils.checBuildingkValidity(TAG, building);
        
        Utils.checkFloorValidity(TAG, floorNo);

        return deskRepository.findDeskListByLocation(building, floorNo);
    }

	@Override
	public List<Desk> listAllDesks(){
		return deskRepository.findAll();
	}
    
    @Override
    public List<Desk> findDesksByBuilding(String building){
    	return deskRepository.listDesksByBuilding(building);
    }


	@Override
	public Desk saveDesk(Desk desk) throws Exception {
		return deskRepository.save(desk);
	}

}
