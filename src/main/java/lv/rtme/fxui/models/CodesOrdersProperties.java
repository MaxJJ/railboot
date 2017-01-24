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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private DoubleProperty cargoWeightDoubleProperty = new SimpleDoubleProperty();

    @Getter
    private StringProperty wagonProperty = new SimpleStringProperty();
    @Getter
    private StringProperty unitProperty = new SimpleStringProperty();
    @Getter
    private DoubleProperty containerTareDoubleProperty = new SimpleDoubleProperty();
    @Getter
    private DoubleProperty cargoTotalGrossDoubleProperty = new SimpleDoubleProperty();
    
    

    @Getter
    private StringProperty providerProperty = new SimpleStringProperty();
    @Getter
    private StringProperty rateProperty = new SimpleStringProperty();
    @Getter
    private DoubleProperty rateDoubleProperty = new SimpleDoubleProperty();
    @Getter
    private StringProperty rateCurrencyProperty = new SimpleStringProperty();
    @Getter
    private DoubleProperty guardRateDoubleProperty = new SimpleDoubleProperty();
    @Getter
    private StringProperty guardCurrencyProperty = new SimpleStringProperty();
    @Getter
    private StringProperty roadsToPayProperty = new SimpleStringProperty();



    @Getter
    private BooleanProperty isOrderedProperty = new SimpleBooleanProperty();
    @Getter
    private BooleanProperty isRequestedProperty = new SimpleBooleanProperty();
    
    @Getter
    private ObjectProperty<Date> orderedOnDateProperty = new SimpleObjectProperty();
    @Getter
    private ObjectProperty<Date> requestedOnDateProperty = new SimpleObjectProperty();
    
    @Getter
    private ObjectProperty<CodesOrders> previuosCodesOrders = new SimpleObjectProperty<>();

    
    public CodesOrdersProperties() {
        co.setValue(new CodesOrders());
        addCOListener();
    
    }
    public CodesOrdersProperties(CodesOrders codesOrders) {
        addCOListener();
        co.setValue(codesOrders);
//        co.setValue(codesOrders);
    }
    
    public void setCodesOrders(CodesOrders orders){
        co.setValue(orders);
    }

    private void addCOListener() {
      
        co.addListener(new ChangeListener<CodesOrders>() {
            @Override
            public void changed(ObservableValue<? extends CodesOrders> observable, CodesOrders oldValue, CodesOrders newValue) {
               
                   getIdLongProperty().setValue(newValue.getId());
      getFileIdProperty().setValue(newValue.getFileID());
     getSearchStringProperty().setValue(newValue.getSearchString());
      
        if (newValue.getStationOfDispatch()!=null) {
            getStationOfDispatchProperty().setValue(newValue.getStationOfDispatch().getStationName());
      getDispatchStationObjectProperty().setValue(newValue.getStationOfDispatch());
        } else {
            getStationOfDispatchProperty().setValue("");
      getDispatchStationObjectProperty().setValue(new Station());
        }
        if (newValue.getStationOfDestination()!=null) {
            getStationOfDestinationProperty().setValue(newValue.getStationOfDestination().getStationName());
            getDestinationStationObjectProperty().setValue(newValue.getStationOfDestination());
        } else {
            getStationOfDestinationProperty().setValue("");
            getDestinationStationObjectProperty().setValue(new Station());
        }
      
        if (newValue.getConsignee()!=null) {
            getConsigneeProperty().setValue(newValue.getConsignee().getSampleName());
            getConsigneeObjectProperty().setValue(newValue.getConsignee());
        } else {
            getConsigneeProperty().setValue("");
            getConsigneeObjectProperty().setValue(new Persons());
        }
      
        
      getCustomTagProperty().setValue(newValue.getCustomTag());
      
      getCargoProperty().setValue(newValue.getCargo());
      getWeightProperty().setValue(newValue.getWeight());
      getCargoWeightDoubleProperty().setValue(newValue.getCargoWeightDouble());
      
      getWagonProperty().setValue(newValue.getWagon());
      getUnitProperty().setValue(newValue.getUnit());
      getContainerTareDoubleProperty().setValue(newValue.getContainerTare());
      getCargoTotalGrossDoubleProperty().setValue(newValue.getCargoTotalGross());
      
      getProviderProperty().setValue(newValue.getProvider());
     getRateProperty().setValue(newValue.getRate());
      getRateDoubleProperty().setValue(newValue.getRateDouble());
      getRateCurrencyProperty().setValue(newValue.getRateCurrency());
      getGuardRateDoubleProperty().setValue(newValue.getGuardRate());
      getGuardCurrencyProperty().setValue(newValue.getGuardCurrency());
      getRoadsToPayProperty().setValue(newValue.getRoadsToPay());
      
      getIsOrderedProperty().setValue(newValue.isIsOrdered());
      getIsRequestedProperty().setValue(newValue.isIsRequested());
      getOrderedOnDateProperty().setValue(newValue.getOrderedOnDate());
      getRequestedOnDateProperty().setValue(newValue.getRequestedOnDate());
            }
        });
    }
}
