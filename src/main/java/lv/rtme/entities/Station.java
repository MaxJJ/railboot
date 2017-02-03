/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import org.springframework.data.annotation.Transient;

/**
 *
 * @author User
 */

@Entity
public  class Station {

       
     @Id
    @GeneratedValue
       private Long id;
     
     private String stationName;
     private String stationRoad;
     private String stationCode;
     private String stationParagraph;
     private boolean isDispatch;
     private boolean isExport;
     private boolean isIn;
     private boolean isOut;
    @Transient
    @Getter
     private String reservationName;
     
     
     public Station() {
    }
     public Station(String reservName) {
         this.reservationName=reservName;
         this.stationName = "test Name";
    }
     

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationRoad() {
        return stationRoad;
    }

    public void setStationRoad(String stationRoad) {
        this.stationRoad = stationRoad;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationParagraph() {
        return stationParagraph;
    }

    public void setStationParagraph(String stationParagraph) {
        this.stationParagraph = stationParagraph;
    }

    public boolean isIsDispatch() {
        return isDispatch;
    }

    public void setIsDispatch(boolean isDispatch) {
        this.isDispatch = isDispatch;
    }

    public boolean isIsExport() {
        return isExport;
    }

    public void setIsExport(boolean isExport) {
        this.isExport = isExport;
    }

    public boolean isIsIn() {
        return isIn;
    }

    public void setIsIn(boolean isIn) {
        this.isIn = isIn;
    }

    public boolean isIsOut() {
        return isOut;
    }

    public void setIsOut(boolean isOut) {
        this.isOut = isOut;
    }

 
     
     
     
    
}
