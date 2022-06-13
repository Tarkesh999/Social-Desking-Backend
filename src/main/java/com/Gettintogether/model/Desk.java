package com.Gettintogether.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Desk {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deskId;

    private String building;

    private int floorNo;

    private int deskNo;

    public Long getDeskId() {
        return deskId;
    }

    public void setDeskId(Long deskId) {
        this.deskId = deskId;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public Integer getDeskNo() {
        return deskNo;
    }

    public void setDeskNo(Integer deskNo) {
        this.deskNo = deskNo;
    }


}
