package com.Gettintogether.controller;

import java.sql.Date;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Gettintogether.model.Slot;
import com.Gettintogether.service.ISlotService;
import com.Gettintogether.utils.Utils;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/slots")
@CrossOrigin(origins="*")
public class SlotController {
    @Autowired
    ISlotService slotService;

    @GetMapping("/all")
    public List<Slot> getAllSlots(){
    	return slotService.listAllSlots();
    }
    
    @GetMapping("/id/{slotId}")
    public ResponseEntity<Slot> getSlotBySlotId(@PathVariable("slotId") Long slotId) {
        try {
            return new ResponseEntity<Slot>(slotService.findSlotBySlotId(slotId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Slot>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Slot>> getSlotByDate(@PathVariable("date") Date date) {
        try {
            return new ResponseEntity<List<Slot>>(slotService.findSlotsByDate(date), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Slot>>( HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/deskid/{deskId}")
    public ResponseEntity<List<Slot>> getSlotByDeskId(@PathVariable("deskId") Long deskId) {
        try {
            return new ResponseEntity<List<Slot>>(slotService.findSlotByDeskId(deskId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Slot>>( HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Slot>> getSlotByStatus(@PathVariable("status") String status) {
        try {
            return new ResponseEntity<List<Slot>>(slotService.findSlotsByStatus(status), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Slot>>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/id/{slotId}")
    public ResponseEntity<?> updateSlotStatus(@RequestBody String status, @PathVariable("slotId") Long slotId) {
    	try {
			Slot slot = slotService.findSlotBySlotId(slotId);
			slot.setStatus(status);
			slotService.save(slot);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }
    
    @PostMapping("/postGetSlot")
    public ResponseEntity insertSlot(@RequestBody Slot slot) {
    	try {
			slotService.save(slot);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
    }
}
