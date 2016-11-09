/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.rtme.services;

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

/**
 *
 * @author Maksims
 */
 public class CodesTableItem {

    private Long id;
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

    private boolean isOrdered;

    private Date orderedOnDate;
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

    public CodesTableItem() {
    }

    public void init()
    {
        fileIdProperty.setValue(fileID);
        stationOfDispatchProperty.setValue(stationOfDispatch.getStationName());
        stationOfDestinationProperty.setValue(stationOfDestination.getStationName());
        
        consigneeProperty.setValue(consignee.getSampleName());
        cargoProperty.setValue(cargo);
        weightProperty.setValue(weight);
        wagonProperty.setValue(wagon);
        providerProperty.setValue(provider);
        rateProperty.setValue(rate);
        rateCurrencyProperty.setValue(rateCurrency);
        unitProperty.setValue(unit);
        roadsToPayProperty.setValue(roadsToPay);
        isOrderedProperty.setValue(isOrdered);
        orderedOnDateProperty.setValue(orderedOnDate);
        codesOrdersProperty.setValue(codesOrders);
        idLongProperty.set(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isIsOrdered() {
        return isOrdered;
    }

    public void setIsOrdered(boolean isOrdered) {
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


