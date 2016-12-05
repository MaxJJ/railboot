/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.models;

import java.util.Date;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lv.rtme.entities.CodesOrders;
import lv.rtme.entities.Persons;
import lv.rtme.entities.Station;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */

@Component("coModel")


public class CodesOrderModel {

    private CodesOrders codesOrders;
    
     //----------- FX Properties  ---------------------------------
    private StringProperty fileIdProperty = new SimpleStringProperty();

    private StringProperty stationOfDispatchProperty = new SimpleStringProperty();
private ObjectProperty<Station> dispatchStationObjectProperty = new SimpleObjectProperty<Station>();
    private StringProperty stationOfDestinationProperty = new SimpleStringProperty();
private ObjectProperty<Station> destinationStationObjectProperty = new SimpleObjectProperty<Station>();

    private StringProperty consigneeProperty = new SimpleStringProperty();
private ObjectProperty<Persons> consigneeObjectProperty = new SimpleObjectProperty<Persons>();
    private StringProperty cargoProperty = new SimpleStringProperty();
    private StringProperty weightProperty = new SimpleStringProperty();

    private StringProperty wagonProperty = new SimpleStringProperty();

    private StringProperty providerProperty = new SimpleStringProperty();

    private StringProperty rateProperty = new SimpleStringProperty();
    private StringProperty rateCurrencyProperty = new SimpleStringProperty();
    private StringProperty unitProperty = new SimpleStringProperty();

    private StringProperty roadsToPayProperty = new SimpleStringProperty();

    private BooleanProperty isOrderedProperty = new SimpleBooleanProperty();
    private ObjectProperty<Date> orderedOnDateProperty = new SimpleObjectProperty();
    private LongProperty idLongProperty = new SimpleLongProperty();
    
    
    public void init(CodesOrders item){
        codesOrders = item;
      this.fileIdProperty.setValue(codesOrders.getFileID());
      this.stationOfDispatchProperty.setValue(codesOrders.getStationOfDispatch().getStationName());
      this.dispatchStationObjectProperty.setValue(codesOrders.getStationOfDispatch());
      this.stationOfDestinationProperty.setValue(codesOrders.getStationOfDestination().getStationName());
      this.destinationStationObjectProperty.setValue(codesOrders.getStationOfDestination());
      this.consigneeProperty.setValue(codesOrders.getConsignee().getSampleName());
      this.consigneeObjectProperty.setValue(codesOrders.getConsignee());
      this.cargoProperty.setValue(codesOrders.getCargo());
      
      this.weightProperty.setValue(codesOrders.getWeight());
      
      this.unitProperty.setValue(codesOrders.getUnit());
      this.wagonProperty.setValue(codesOrders.getWagon());
      this.rateProperty.setValue(codesOrders.getRate());
      this.rateCurrencyProperty.setValue(codesOrders.getRateCurrency());
      this.providerProperty.setValue(codesOrders.getProvider());
      this.roadsToPayProperty.setValue(codesOrders.getRoadsToPay());
    }
    public void initEmpty(CodesOrders item){
        codesOrders = item;
      this.fileIdProperty.setValue("");
      this.stationOfDispatchProperty.setValue("");
      this.dispatchStationObjectProperty.setValue(null);
      this.stationOfDestinationProperty.setValue("");
      this.destinationStationObjectProperty.setValue(null);
      this.consigneeProperty.setValue("");
      this.consigneeObjectProperty.setValue(null);
      this.cargoProperty.setValue("");
      
      this.weightProperty.setValue("");
      
      this.unitProperty.setValue("");
      this.wagonProperty.setValue("");
      this.rateProperty.setValue("");
      this.rateCurrencyProperty.setValue("");
      this.providerProperty.setValue("");
      this.roadsToPayProperty.setValue("");
    }
    @Lazy(true)
    @Bean(name="tableItem")
    @Scope("prototype")
    
    CodesOrderModel getInstance(){
        
        return new CodesOrderModel();
    }

    public CodesOrders getCodesOrders() {
        return codesOrders;
    }

    public void setCodesOrders(CodesOrders codesOrders) {
        this.codesOrders = codesOrders;
    }

    public StringProperty getFileIdProperty() {
        return fileIdProperty;
    }

    public void setFileIdProperty(StringProperty fileIdProperty) {
        this.fileIdProperty = fileIdProperty;
    }

    public StringProperty getStationOfDispatchProperty() {
        return stationOfDispatchProperty;
    }

    public void setStationOfDispatchProperty(StringProperty stationOfDispatchProperty) {
        this.stationOfDispatchProperty = stationOfDispatchProperty;
    }

    public StringProperty getStationOfDestinationProperty() {
        return stationOfDestinationProperty;
    }

    public void setStationOfDestinationProperty(StringProperty stationOfDestinationProperty) {
        this.stationOfDestinationProperty = stationOfDestinationProperty;
    }

    public StringProperty getConsigneeProperty() {
        return consigneeProperty;
    }

    public void setConsigneeProperty(StringProperty consigneeProperty) {
        this.consigneeProperty = consigneeProperty;
    }

    public StringProperty getCargoProperty() {
        return cargoProperty;
    }

    public void setCargoProperty(StringProperty cargoProperty) {
        this.cargoProperty = cargoProperty;
    }

    public StringProperty getWeightProperty() {
        return weightProperty;
    }

    public void setWeightProperty(StringProperty weightProperty) {
        this.weightProperty = weightProperty;
    }

    public StringProperty getWagonProperty() {
        return wagonProperty;
    }

    public void setWagonProperty(StringProperty wagonProperty) {
        this.wagonProperty = wagonProperty;
    }

    public StringProperty getProviderProperty() {
        return providerProperty;
    }

    public void setProviderProperty(StringProperty providerProperty) {
        this.providerProperty = providerProperty;
    }

    public StringProperty getRateProperty() {
        return rateProperty;
    }

    public void setRateProperty(StringProperty rateProperty) {
        this.rateProperty = rateProperty;
    }

    public StringProperty getRateCurrencyProperty() {
        return rateCurrencyProperty;
    }

    public void setRateCurrencyProperty(StringProperty rateCurrencyProperty) {
        this.rateCurrencyProperty = rateCurrencyProperty;
    }

    public StringProperty getUnitProperty() {
        return unitProperty;
    }

    public void setUnitProperty(StringProperty unitProperty) {
        this.unitProperty = unitProperty;
    }

    public StringProperty getRoadsToPayProperty() {
        return roadsToPayProperty;
    }

    public void setRoadsToPayProperty(StringProperty roadsToPayProperty) {
        this.roadsToPayProperty = roadsToPayProperty;
    }

    public BooleanProperty getIsOrderedProperty() {
        return isOrderedProperty;
    }

    public void setIsOrderedProperty(BooleanProperty isOrderedProperty) {
        this.isOrderedProperty = isOrderedProperty;
    }

    public ObjectProperty<Date> getOrderedOnDateProperty() {
        return orderedOnDateProperty;
    }

    public void setOrderedOnDateProperty(ObjectProperty<Date> orderedOnDateProperty) {
        this.orderedOnDateProperty = orderedOnDateProperty;
    }


    public LongProperty getIdLongProperty() {
        return idLongProperty;
    }

    public void setIdLongProperty(LongProperty idLongProperty) {
        this.idLongProperty = idLongProperty;
    }

    public ObjectProperty<Station> getDispatchStationObjectProperty() {
        return dispatchStationObjectProperty;
    }

    public void setDispatchStationObjectProperty(ObjectProperty<Station> dispatchStationObjectProperty) {
        this.dispatchStationObjectProperty = dispatchStationObjectProperty;
    }

    public ObjectProperty<Station> getDestinationStationObjectProperty() {
        return destinationStationObjectProperty;
    }

    public void setDestinationStationObjectProperty(ObjectProperty<Station> destinationStationObjectProperty) {
        this.destinationStationObjectProperty = destinationStationObjectProperty;
    }

    public ObjectProperty<Persons> getConsigneeObjectProperty() {
        return consigneeObjectProperty;
    }

    public void setConsigneeObjectProperty(ObjectProperty<Persons> consigneeObjectProperty) {
        this.consigneeObjectProperty = consigneeObjectProperty;
    }

  

   
    
    
}
