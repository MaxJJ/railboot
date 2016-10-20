/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
     
     public Station() {
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

 
     
     
     
    
}
