package com.Gettintogether.dto;

import org.springframework.context.annotation.Bean;

public class UserBookingDTO {
	
	
	private Long transactionId;
	private String emailId;
	private java.sql.Date slotDate;
	private String Building;
	private int floorNo;
	private int deskNo;
	
	
	
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public java.sql.Date getSlotDate() {
		return slotDate;
	}
	public void setSlotDate(java.sql.Date slotDate) {
		this.slotDate = slotDate;
	}
	public String getBuilding() {
		return Building;
	}
	public void setBuilding(String building) {
		Building = building;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public int getDeskNo() {
		return deskNo;
	}
	public void setDeskNo(int deskNo) {
		this.deskNo = deskNo;
	}
	

	
	
}
