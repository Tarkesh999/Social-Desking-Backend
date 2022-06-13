package com.Gettintogether.service;

import java.util.List;

import com.Gettintogether.dto.UserBookingDTO;
import com.Gettintogether.model.Booking;
import com.Gettintogether.model.User;

public interface IUserService {

    User findUserByEmail(String email);

    List<User> findUserByTeam(String teamId);

    List<UserBookingDTO> findTeamDetails(String teamId);
    
    List<User> findAllUsers();
    
    User insertUser(User user)throws Exception;
}
