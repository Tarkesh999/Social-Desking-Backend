package com.Gettintogether.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Gettintogether.model.Desk;
import com.Gettintogether.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	@Query("SELECT u FROM User u WHERE u.teamId =:t")
	public List<User> findUserByTeamId(@Param("t")String teamId);
}