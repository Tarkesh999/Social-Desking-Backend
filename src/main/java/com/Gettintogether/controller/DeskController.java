package com.Gettintogether.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gettintogether.model.Desk;
import com.Gettintogether.service.IDeskService;

@RestController
@RequestMapping("/desk")
@CrossOrigin(origins="*")
public class DeskController {
	
	@Autowired
	private IDeskService deskServiceImpl;
	
	@GetMapping("/all")
	public List<Desk> listAllDesks(){
		return deskServiceImpl.listAllDesks();
	}
	
	@GetMapping("/{deskId}")
	public ResponseEntity<Desk> getDeskById(@PathVariable Long deskId) {
		try {
			Desk deskObj =  deskServiceImpl.findDeskById(deskId);
			return new ResponseEntity<Desk>(deskObj, HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<Desk>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/building/{building}")
	public ResponseEntity<List<Desk>> listDesksByBuilding(@PathVariable String building){
		try {
			List<Desk> deskList = deskServiceImpl.findDesksByBuilding(building);
			return new ResponseEntity<List<Desk>>(deskList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Desk>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/building/{building}/floor/{floor}")
	public ResponseEntity<List<Desk>> listDesksByBuildingAndFloor(@PathVariable String building, @PathVariable int floor){
		try {
			List<Desk> deskList = deskServiceImpl.findDeskListByLocation(building, floor);
			return new ResponseEntity<List<Desk>>(deskList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Desk>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/building/{building}/floor/{floor}/deskno/{deskno}")
	public ResponseEntity<Desk> getDeskByLocation(@PathVariable String building, @PathVariable int floor,@PathVariable int deskno){
		try {
			Desk desk = deskServiceImpl.findDeskByLocation(building, floor, deskno);
			return new ResponseEntity<Desk>(desk, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Desk>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/postGetDesk")
    public ResponseEntity insertDesk(@RequestBody Desk desk){
    	try {
			deskServiceImpl.saveDesk(desk);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
    }

}
