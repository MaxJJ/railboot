/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.fxui.models;

import java.util.Date;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
    private LongProperty idLongProperty = new SimpleLongProperty();
    
    private StringProperty fileIdProperty = new SimpleStringProperty();

    private StringProperty searchStringProperty = new SimpleStringProperty();

    private StringProperty stationOfDispatchProperty = new SimpleStringProperty();
    private ObjectProperty<Station> dispatchStationObjectProperty = new SimpleObjectProperty<Station>();
    private StringProperty stationOfDestinationProperty = new SimpleStringProperty();
    private ObjectProperty<Station> destinationStationObjectProperty = new SimpleObjectProperty<Station>();

    private StringProperty consigneeProperty = new SimpleStringProperty();
    private ObjectProperty<Persons> consigneeObjectProperty = new SimpleObjectProperty<Persons>();

    private StringProperty customTagProperty = new SimpleStringProperty();

    private StringProperty cargoProperty = new SimpleStringProperty();
    private StringProperty weightProperty = new SimpleStringProperty();
    private DoubleProperty cargoWeightDoubleProperty = new SimpleDoubleProperty();

    private StringProperty wagonProperty = new SimpleStringProperty();
    private StringProperty unitProperty = new SimpleStringProperty();
    private DoubleProperty containerTareDoubleProperty = new SimpleDoubleProperty();
    private DoubleProperty cargoTotalGrossDoubleProperty = new SimpleDoubleProperty();
    

    private StringProperty providerProperty = new SimpleStringProperty();
    private StringProperty rateProperty = new SimpleStringProperty();
    private DoubleProperty rateDoubleProperty = new SimpleDoubleProperty();
    private StringProperty rateCurrencyProperty = new SimpleStringProperty();
    private DoubleProperty guardRateDoubleProperty = new SimpleDoubleProperty();
    private StringProperty guardCurrencyProperty = new SimpleStringProperty();
    private StringProperty roadsToPayProperty = new SimpleStringProperty();



    private BooleanProperty isOrderedProperty = new SimpleBooleanProperty();
    private BooleanProperty isRequestedProperty = new SimpleBooleanProperty();
    
    private ObjectProperty<Date> orderedOnDateProperty = new SimpleObjectProperty();
    private ObjectProperty<Date> requestedOnDateProperty = new SimpleObjectProperty();
    
    private ObjectProperty<CodesOrders> previuosCodesOrders = new SimpleObjectProperty<>();
    
    
    public void init(CodesOrders item){
        this.previuosCodesOrders.setValue(codesOrders);
        
        codesOrders = item;
        this.idLongProperty.setValue(codesOrders.getId());
      this.fileIdProperty.setValue(codesOrders.getFileID());
      this.searchStringProperty.setValue(codesOrders.getSearchString());
      
        if (codesOrders.getStationOfDispatch()!=null) {
            this.stationOfDispatchProperty.setValue(codesOrders.getStationOfDispatch().getStationName());
      this.dispatchStationObjectProperty.setValue(codesOrders.getStationOfDispatch());
        } else {
            this.stationOfDispatchProperty.setValue("");
      this.dispatchStationObjectProperty.setValue(new Station());
        }
        if (codesOrders.getStationOfDestination()!=null) {
            this.stationOfDestinationProperty.setValue(codesOrders.getStationOfDestination().getStationName());
            this.destinationStationObjectProperty.setValue(codesOrders.getStationOfDestination());
        } else {
            this.stationOfDestinationProperty.setValue("");
            this.destinationStationObjectProperty.setValue(new Station());
        }
      
        if (codesOrders.getConsignee()!=null) {
            this.consigneeProperty.setValue(codesOrders.getConsignee().getSampleName());
            this.consigneeObjectProperty.setValue(codesOrders.getConsignee());
        } else {
            this.consigneeProperty.setValue("");
            this.consigneeObjectProperty.setValue(new Persons());
        }
      
        
      this.customTagProperty.setValue(codesOrders.getCustomTag());
      
      this.cargoProperty.setValue(codesOrders.getCargo());
      this.weightProperty.setValue(codesOrders.getWeight());
      this.cargoWeightDoubleProperty.setValue(codesOrders.getCargoWeightDouble());
      
      this.wagonProperty.setValue(codesOrders.getWagon());
      this.unitProperty.setValue(codesOrders.getUnit());
      this.containerTareDoubleProperty.setValue(codesOrders.getContainerTare());
      this.cargoTotalGrossDoubleProperty.setValue(codesOrders.getCargoTotalGross());
      
      this.providerProperty.setValue(codesOrders.getProvider());
      this.rateProperty.setValue(codesOrders.getRate());
      this.rateDoubleProperty.setValue(codesOrders.getRateDouble());
      this.rateCurrencyProperty.setValue(codesOrders.getRateCurrency());
      this.guardRateDoubleProperty.setValue(codesOrders.getGuardRate());
      this.guardCurrencyProperty.setValue(codesOrders.getGuardCurrency());
      this.roadsToPayProperty.setValue(codesOrders.getRoadsToPay());
      
      this.isOrderedProperty.setValue(codesOrders.isIsOrdered());
      this.isRequestedProperty.setValue(codesOrders.isIsRequested());
      this.orderedOnDateProperty.setValue(codesOrders.getOrderedOnDate());
      this.requestedOnDateProperty.setValue(codesOrders.getRequestedOnDate());
      
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

    public StringProperty getSearchStringProperty() {
        return searchStringProperty;
    }

    public void setSearchStringProperty(StringProperty searchStringProperty) {
        this.searchStringProperty = searchStringProperty;
    }

    public StringProperty getCustomTagProperty() {
        return customTagProperty;
    }

    public void setCustomTagProperty(StringProperty customTagProperty) {
        this.customTagProperty = customTagProperty;
    }

    public DoubleProperty getCargoWeightDoubleProperty() {
        return cargoWeightDoubleProperty;
    }

    public void setCargoWeightDoubleProperty(DoubleProperty cargoWeightDoubleProperty) {
        this.cargoWeightDoubleProperty = cargoWeightDoubleProperty;
    }

    public DoubleProperty getContainerTareDoubleProperty() {
        return containerTareDoubleProperty;
    }

    public void setContainerTareDoubleProperty(DoubleProperty containerTareDoubleProperty) {
        this.containerTareDoubleProperty = containerTareDoubleProperty;
    }

    public DoubleProperty getCargoTotalGrossDoubleProperty() {
        return cargoTotalGrossDoubleProperty;
    }

    public void setCargoTotalGrossDoubleProperty(DoubleProperty cargoTotalGrossDoubleProperty) {
        this.cargoTotalGrossDoubleProperty = cargoTotalGrossDoubleProperty;
    }

    public DoubleProperty getRateDoubleProperty() {
        return rateDoubleProperty;
    }

    public void setRateDoubleProperty(DoubleProperty rateDoubleProperty) {
        this.rateDoubleProperty = rateDoubleProperty;
    }

    public DoubleProperty getGuardRateDoubleProperty() {
        return guardRateDoubleProperty;
    }

    public void setGuardRateDoubleProperty(DoubleProperty guardRateDoubleProperty) {
        this.guardRateDoubleProperty = guardRateDoubleProperty;
    }

    public StringProperty getGuardCurrencyProperty() {
        return guardCurrencyProperty;
    }

    public void setGuardCurrencyProperty(StringProperty guardCurrencyProperty) {
        this.guardCurrencyProperty = guardCurrencyProperty;
    }

    public BooleanProperty getIsRequestedProperty() {
        return isRequestedProperty;
    }

    public void setIsRequestedProperty(BooleanProperty isRequestedProperty) {
        this.isRequestedProperty = isRequestedProperty;
    }

    public ObjectProperty<Date> getRequestedOnDateProperty() {
        return requestedOnDateProperty;
    }

    public void setRequestedOnDateProperty(ObjectProperty<Date> requestedOnDateProperty) {
        this.requestedOnDateProperty = requestedOnDateProperty;
    }

    public ObjectProperty<CodesOrders> getPreviuosCodesOrders() {
        return previuosCodesOrders;
    }

    public void setPreviuosCodesOrders(ObjectProperty<CodesOrders> previuosCodesOrders) {
        this.previuosCodesOrders = previuosCodesOrders;
    }

  

   
    
    
}
