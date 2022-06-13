package com.Gettintogether.controller;

import java.util.List;

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

import com.Gettintogether.dto.UserBookingDTO;
import com.Gettintogether.model.User;
import com.Gettintogether.service.IUserService;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        try {
            return new ResponseEntity<User>(userService.findUserByEmail(email), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<User>> getUserByTeam(@PathVariable("teamId") String teamId) {
        try {
            return new ResponseEntity<List<User>>(userService.findUserByTeam(teamId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/details/{teamId}")
    public ResponseEntity<List<UserBookingDTO>> getTeamDetails(@PathVariable("teamId") String teamId) {
        try {
            return new ResponseEntity<List<UserBookingDTO>>(userService.findTeamDetails(teamId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<UserBookingDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/postGetUser")
    public ResponseEntity insertUser(@RequestBody User user) {
    	try {
			userService.insertUser(user);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
    }
}
