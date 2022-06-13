package com.Gettintogether.repository;

import java.util.List;
import com.Gettintogether.model.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeskRepository extends JpaRepository<Desk, Long> {

    Desk findByDeskId(Long deskId);

    @Query("SELECT d FROM Desk d WHERE d.building = :b AND d.floorNo = :f AND d.deskNo = :dno")
    Desk findByDeskLocation(@Param("b")String building, @Param("f")int floor,@Param("dno") int deskNo);
    
    @Query("SELECT d FROM Desk d WHERE d.building =:b and d.floorNo =:f")
    List<Desk> findDeskListByLocation(@Param("b")String building,@Param("f")int floor);
	
	@Query("SELECT d FROM Desk d WHERE d.building =:b")
	public List<Desk> listDesksByBuilding(@Param("b")String building);
	
	@Query("SELECT d FROM Desk d WHERE d.building =:b and d.floorNo =:f")
	public List<Desk> listDesksByBuildingAndFloor(@Param("b")String building, @Param("f")int floorNo);

	@Query("SELECT d FROM Desk d WHERE d.building =:b and d.floorNo =:f and d.deskNo =:dno")
	public Desk findDeskByLocation(@Param("b")String building, @Param("f")int floorNo,@Param("dno")int dno);
}
