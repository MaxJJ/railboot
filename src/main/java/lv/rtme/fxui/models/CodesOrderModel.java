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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksims
 */

@Component
@Scope("prototype")

public class CodesOrderModel {

    private CodesOrders codesOrders;
    
     //----------- FX Properties  ---------------------------------
    private StringProperty fileIdProperty = new SimpleStringProperty();

    private StringProperty stationOfDispatchProperty = new SimpleStringProperty();

    private StringProperty stationOfDestinationProperty = new SimpleStringProperty();

    private StringProperty consigneeProperty = new SimpleStringProperty();

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
    private ObjectProperty<CodesOrders> codesOrdersProperty = new SimpleObjectProperty<>();
    private LongProperty idLongProperty = new SimpleLongProperty();
    
    
    public void init(CodesOrders item){
        codesOrders = item;
      this.fileIdProperty.setValue(codesOrders.getFileID());
      this.stationOfDispatchProperty.setValue(codesOrders.getStationOfDispatch().getStationName());
      this.stationOfDestinationProperty.setValue(codesOrders.getStationOfDestination().getStationName());
      this.consigneeProperty.setValue(codesOrders.getConsignee().getSampleName());
      this.cargoProperty.setValue(codesOrders.getCargo());
      
      this.weightProperty.setValue(codesOrders.getWeight());
      
      this.unitProperty.setValue(codesOrders.getUnit());
      this.wagonProperty.setValue(codesOrders.getWagon());
      this.rateProperty.setValue(codesOrders.getRate());
      this.rateCurrencyProperty.setValue(codesOrders.getRateCurrency());
      this.providerProperty.setValue(codesOrders.getProvider());
      this.roadsToPayProperty.setValue(codesOrders.getRoadsToPay());
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

    public ObjectProperty<CodesOrders> getCodesOrdersProperty() {
        return codesOrdersProperty;
    }

    public void setCodesOrdersProperty(ObjectProperty<CodesOrders> codesOrdersProperty) {
        this.codesOrdersProperty = codesOrdersProperty;
    }

    public LongProperty getIdLongProperty() {
        return idLongProperty;
    }

    public void setIdLongProperty(LongProperty idLongProperty) {
        this.idLongProperty = idLongProperty;
    }

  

   
    
    
}
