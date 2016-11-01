/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.models;

import java.util.Date;
import lv.rtme.entities.CodesOrders;
import lv.rtme.entities.Persons;
import lv.rtme.entities.Station;
import lv.rtme.services.CodesTableItem;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */

@Component

public class CodesOrderModel {
    
    private String fileID;

    private Station stationOfDispatch;

    private Station stationOfDestination;

    private Persons consignee;

    private String cargo;
    private String weight;

    private String wagon;

    private String provider;

    private String rate;
    private String rateCurrency;
    private String unit;

    private String roadsToPay;

    private String isOrdered;

    private Date orderedOnDate;
    
    private CodesOrders codesOrders;
    private CodesTableItem coTab;
    
    
    public void init(CodesTableItem item){
        this.coTab=item;
        codesOrders = item.getCodesOrdersProperty().getValue();
      this.fileID =  codesOrders.getFileID();
      this.stationOfDispatch= codesOrders.getStationOfDispatch();
      this.stationOfDestination= codesOrders.getStationOfDestination();
      this.consignee=codesOrders.getConsignee();
      this.cargo=codesOrders.getCargo();
      
      this.weight=codesOrders.getWeight();
      
      this.unit=codesOrders.getUnit();
      this.wagon=codesOrders.getWagon();
      this.rate=codesOrders.getRate();
      this.rateCurrency=codesOrders.getRateCurrency();
      this.provider=codesOrders.getProvider();
      this.roadsToPay = codesOrders.getRoadsToPay();
    }

    public String getFileID() {
        return fileID;
    }

    public void setFileID(String fileID) {
        this.fileID = fileID;
    }

    public Station getStationOfDispatch() {
        return stationOfDispatch;
    }

    public void setStationOfDispatch(Station stationOfDispatch) {
        this.stationOfDispatch = stationOfDispatch;
    }

    public Station getStationOfDestination() {
        return stationOfDestination;
    }

    public void setStationOfDestination(Station stationOfDestination) {
        this.stationOfDestination = stationOfDestination;
    }

    public Persons getConsignee() {
        return consignee;
    }

    public void setConsignee(Persons consignee) {
        this.consignee = consignee;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWagon() {
        return wagon;
    }

    public void setWagon(String wagon) {
        this.wagon = wagon;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRateCurrency() {
        return rateCurrency;
    }

    public void setRateCurrency(String rateCurrency) {
        this.rateCurrency = rateCurrency;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRoadsToPay() {
        return roadsToPay;
    }

    public void setRoadsToPay(String roadsToPay) {
        this.roadsToPay = roadsToPay;
    }

    public String getIsOrdered() {
        return isOrdered;
    }

    public void setIsOrdered(String isOrdered) {
        this.isOrdered = isOrdered;
    }

    public Date getOrderedOnDate() {
        return orderedOnDate;
    }

    public void setOrderedOnDate(Date orderedOnDate) {
        this.orderedOnDate = orderedOnDate;
    }

    public CodesOrders getCodesOrders() {
        return codesOrders;
    }

   
    
    
}
