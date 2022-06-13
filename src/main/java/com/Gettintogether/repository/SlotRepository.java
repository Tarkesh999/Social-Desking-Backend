package com.Gettintogether.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Gettintogether.model.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

    @Query(
        value = "INSERT INTO slot VALUES(null, :date, :status, :deskID",
        nativeQuery = true
    )
    void createNewSlot(Date date, String status, Long deskID);

    Slot findBySlotId(Long slotId);
	
	@Query("SELECT s FROM Slot s WHERE s.slotDate =:date")
    List<Slot> findSlotByDate(Date date);
    
    @Query("SELECT s FROM Slot s WHERE s.deskId =:deskId")
    List<Slot> findSlotByDeskId(Long deskId);
    
    @Query("SELECT s FROM Slot s WHERE s.status =:status")
    List<Slot> findSlotByStatus(String status);
    
   
    
    
    
}
