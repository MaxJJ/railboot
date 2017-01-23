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
        addCOListener();
    
    }
    public CodesOrdersProperties(CodesOrders codesOrders) {
        
        co.setValue(codesOrders);
    }
    
    public void setCodesOrders(CodesOrders orders){
        co.setValue(orders);
    }

    private void addCOListener() {
      
        co.addListener(new ChangeListener<CodesOrders>() {
            @Override
            public void changed(ObservableValue<? extends CodesOrders> observable, CodesOrders oldValue, CodesOrders newValue) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
}
