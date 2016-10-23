/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.services;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Maksims
 */
        public class CodesTableItem {
         private StringProperty fileID = new SimpleStringProperty();

    private StringProperty stationOfDispatch = new SimpleStringProperty();

    private  StringProperty stationOfDestination = new SimpleStringProperty();

    private StringProperty consignee = new SimpleStringProperty();

    private StringProperty cargo= new SimpleStringProperty();
    private StringProperty weight= new SimpleStringProperty();

    private StringProperty wagon= new SimpleStringProperty();

    private StringProperty provider= new SimpleStringProperty();

    private StringProperty rate= new SimpleStringProperty();
    private StringProperty rateCurrency= new SimpleStringProperty();
    private StringProperty unit= new SimpleStringProperty();

    private StringProperty roadsToPay= new SimpleStringProperty();

    private StringProperty isOrdered= new SimpleStringProperty();

    private StringProperty orderedOnDate=new SimpleStringProperty();
    

        public CodesTableItem() {
        }

        public StringProperty getFileID() {
            return fileID;
        }

        public void setFileID(StringProperty fileID) {
            this.fileID = fileID;
        }

        public StringProperty getStationOfDispatch() {
            return stationOfDispatch;
        }

        public void setStationOfDispatch(StringProperty stationOfDispatch) {
            this.stationOfDispatch = stationOfDispatch;
        }

        public StringProperty getStationOfDestination() {
            return stationOfDestination;
        }

        public void setStationOfDestination(StringProperty stationOfDestination) {
            this.stationOfDestination = stationOfDestination;
        }

        public StringProperty getConsignee() {
            return consignee;
        }

        public void setConsignee(StringProperty consignee) {
            this.consignee = consignee;
        }

        public StringProperty getCargo() {
            return cargo;
        }

        public void setCargo(StringProperty cargo) {
            this.cargo = cargo;
        }

        public StringProperty getWeight() {
            return weight;
        }

        public void setWeight(StringProperty weight) {
            this.weight = weight;
        }

        public StringProperty getWagon() {
            return wagon;
        }

        public void setWagon(StringProperty wagon) {
            this.wagon = wagon;
        }

        public StringProperty getProvider() {
            return provider;
        }

        public void setProvider(StringProperty provider) {
            this.provider = provider;
        }

        public StringProperty getRate() {
            return rate;
        }

        public void setRate(StringProperty rate) {
            this.rate = rate;
        }

        public StringProperty getRateCurrency() {
            return rateCurrency;
        }

        public void setRateCurrency(StringProperty rateCurrency) {
            this.rateCurrency = rateCurrency;
        }

        public StringProperty getUnit() {
            return unit;
        }

        public void setUnit(StringProperty unit) {
            this.unit = unit;
        }

        public StringProperty getRoadsToPay() {
            return roadsToPay;
        }

        public void setRoadsToPay(StringProperty roadsToPay) {
            this.roadsToPay = roadsToPay;
        }

        public StringProperty getIsOrdered() {
            return isOrdered;
        }

        public void setIsOrdered(StringProperty isOrdered) {
            this.isOrdered = isOrdered;
        }

        public StringProperty getOrderedOnDate() {
            return orderedOnDate;
        }

        public void setOrderedOnDate(StringProperty orderedOnDate) {
            this.orderedOnDate = orderedOnDate;
        }
        
        
    }


