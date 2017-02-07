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
import lombok.Getter;
import lv.rtme.entities.CodesOrders;
import lv.rtme.entities.Persons;
import lv.rtme.entities.Station;

/**
 *
 * @author Maksims
 */
public class CodesOrdersProperties {
    @Getter
    private ObjectProperty<CodesOrders> co = new SimpleObjectProperty<>();
    
    @Getter
      private LongProperty idLongProperty = new SimpleLongProperty();
    
    @Getter
    private StringProperty fileIdProperty = new SimpleStringProperty();

    @Getter
    private StringProperty searchStringProperty = new SimpleStringProperty();

    @Getter
    private StringProperty stationOfDispatchProperty = new SimpleStringProperty();
    @Getter
    private ObjectProperty<Station> dispatchStationObjectProperty = new SimpleObjectProperty<Station>();
    @Getter
    private StringProperty stationOfDestinationProperty = new SimpleStringProperty();
    @Getter
    private ObjectProperty<Station> destinationStationObjectProperty = new SimpleObjectProperty<Station>();

    @Getter
    private StringProperty consigneeProperty = new SimpleStringProperty();
    @Getter
    private ObjectProperty<Persons> consigneeObjectProperty = new SimpleObjectProperty<Persons>();

    @Getter
    private StringProperty customTagProperty = new SimpleStringProperty();

    @Getter
    private StringProperty cargoProperty = new SimpleStringProperty();
    @Getter
    private StringProperty weightProperty = new SimpleStringProperty();

    @Getter
    private StringProperty wagonProperty = new SimpleStringProperty();
    @Getter
    private StringProperty unitProperty = new SimpleStringProperty();
    
    

    @Getter
    private StringProperty providerProperty = new SimpleStringProperty();
    @Getter
    private StringProperty rateProperty = new SimpleStringProperty();
    @Getter
    private StringProperty roadsToPayProperty = new SimpleStringProperty();
    @Getter
    private StringProperty paymentsCommentsProperty = new SimpleStringProperty();
    @Getter
    private StringProperty periodProperty = new SimpleStringProperty();



    @Getter
    private BooleanProperty isOrderedProperty = new SimpleBooleanProperty();
    @Getter
    private BooleanProperty isRequestedProperty = new SimpleBooleanProperty();
    @Getter
    private BooleanProperty isContainerisedProperty = new SimpleBooleanProperty();
    
    @Getter
    private ObjectProperty<Date> orderedOnDateProperty = new SimpleObjectProperty();
    @Getter
    private ObjectProperty<Date> requestedOnDateProperty = new SimpleObjectProperty();
    
    @Getter
    private ObjectProperty<CodesOrders> previuosCodesOrders = new SimpleObjectProperty<>();

    
    public CodesOrdersProperties() {

        setCodesOrders(new CodesOrders());
    
    }
    public CodesOrdersProperties(CodesOrders codesOrders) {
setCodesOrders(codesOrders);
    }
    
    public void setCodesOrders(CodesOrders orders){
        co.setValue(orders);
        
                   getIdLongProperty().setValue(orders.getId());
      getFileIdProperty().setValue(orders.getFileID());
     getSearchStringProperty().setValue(orders.getSearchString());
      
        if (orders.getStationOfDispatch()!=null) {
            getStationOfDispatchProperty().setValue(orders.getStationOfDispatch().getStationName());
      getDispatchStationObjectProperty().setValue(orders.getStationOfDispatch());
        } else {
            getStationOfDispatchProperty().setValue("");
      getDispatchStationObjectProperty().setValue(new Station());
        }
        if (orders.getStationOfDestination()!=null) {
            getStationOfDestinationProperty().setValue(orders.getStationOfDestination().getStationName());
            getDestinationStationObjectProperty().setValue(orders.getStationOfDestination());
        } else {
            getStationOfDestinationProperty().setValue("");
            getDestinationStationObjectProperty().setValue(new Station());
        }
      
        if (orders.getConsignee()!=null) {
            getConsigneeProperty().setValue(orders.getConsignee().getSampleName());
            getConsigneeObjectProperty().setValue(orders.getConsignee());
        } else {
            getConsigneeProperty().setValue("");
            getConsigneeObjectProperty().setValue(new Persons());
        }
      
        
      getCustomTagProperty().setValue(orders.getCustomTag());
      
      getCargoProperty().setValue(orders.getCargo());
      getWeightProperty().setValue(orders.getWeight());
      
      getWagonProperty().setValue(orders.getWagon());
      getUnitProperty().setValue(orders.getUnit());
      getIsContainerisedProperty().setValue(orders.isIsContainerised());
      
      getProviderProperty().setValue(orders.getProvider());
     getRateProperty().setValue(orders.getRate());
      getRoadsToPayProperty().setValue(orders.getRoadsToPay());
      
      getIsOrderedProperty().setValue(orders.isIsOrdered());
      getIsRequestedProperty().setValue(orders.isIsRequested());
      getOrderedOnDateProperty().setValue(orders.getOrderedOnDate());
      getRequestedOnDateProperty().setValue(orders.getRequestedOnDate());
      
      getPaymentsCommentsProperty().setValue(orders.getPaymentsComments());
      getPeriodProperty().setValue(orders.getPeriodToPay());
    }

    public CodesOrders getUpdatedCodesOrders() {
        CodesOrders updated = getCo().getValue();

        updated.setFileID(getFileIdProperty().getValueSafe());

        String search = "";
        search = search.concat(getFileIdProperty().getValueSafe()).
                concat(getCustomTagProperty().getValueSafe());

        updated.setSearchString(search);
        updated.setStationOfDispatch(getDispatchStationObjectProperty().getValue());
        updated.setStationOfDestination(getDestinationStationObjectProperty().getValue());
        updated.setConsignee(getConsigneeObjectProperty().getValue());
        updated.setCustomTag(getCustomTagProperty().getValue());
        updated.setCargo(getCargoProperty().getValueSafe());
        updated.setWeight(getWeightProperty().getValueSafe());
        updated.setWagon(getWagonProperty().getValueSafe());
        updated.setUnit(getUnitProperty().getValueSafe());
        updated.setIsContainerised(getIsContainerisedProperty().getValue());
        updated.setProvider(getProviderProperty().getValueSafe());
        updated.setRate(getRateProperty().getValueSafe());
        updated.setRoadsToPay(getRoadsToPayProperty().getValueSafe());
        updated.setIsOrdered(getIsOrderedProperty().getValue());
        updated.setIsRequested(getIsRequestedProperty().getValue());
        updated.setOrderedOnDate(getOrderedOnDateProperty().getValue());
        updated.setRequestedOnDate(getRequestedOnDateProperty().getValue());
        updated.setPaymentsComments(getPaymentsCommentsProperty().getValueSafe());
        updated.setPeriodToPay(getPeriodProperty().getValueSafe());

        return updated;

    }
}
