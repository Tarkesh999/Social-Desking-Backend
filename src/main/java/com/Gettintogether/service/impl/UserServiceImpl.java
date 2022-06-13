package com.Gettintogether.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gettintogether.dto.UserBookingDTO;
import com.Gettintogether.facade.UserBookingFacade;
import com.Gettintogether.model.User;
import com.Gettintogether.repository.UserRepository;
import com.Gettintogether.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserBookingFacade userBookingFacade;
    
    @Override
    public User findUserByEmail(String email) {

    	String regex = "^(.+)@(.+)$";
    	 
    	Pattern pattern = Pattern.compile(regex);
    	
    	Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
        return userRepository.findById(email).get();
    }

    @Override
    public List<User> findUserByTeam(String teamId) {
        return userRepository.findUserByTeamId(teamId);
    }

    @Override
    public List<UserBookingDTO> findTeamDetails(String teamId){
    	List<User> team = findUserByTeam(teamId);
    	List<UserBookingDTO> teamdetails= new ArrayList<>();
    	for(User user: team) {
    		System.out.println(userBookingFacade.findBookingByEmail(user.getUserEmail()));
    		teamdetails.addAll(userBookingFacade.findBookingByEmail(user.getUserEmail()));
    	}
    	
    	return teamdetails;
    }

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User insertUser(User user) throws Exception {
		
		return userRepository.save(user);
	}
}
