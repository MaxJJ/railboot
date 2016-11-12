package lv.rtme.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;


@Entity
public class CodesOrders {

    @Id
    @GeneratedValue
    private Long id;
    
    private  String fileID;
    
    @Lob
    private String searchString;
    
    @OneToOne
    @JoinColumn(name = "dispatchstation_fk")
  
    private Station stationOfDispatch;

    @OneToOne
    @JoinColumn(name = "destinationstation_fk")
    private Station stationOfDestination;

    @OneToOne
    @JoinColumn(name = "consignee_fk")
    private Persons consignee;
    
    @Lob
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
    
    
    private String reservationName;

    @Override
    public String toString() {
        return "A reservation{"
                + "id:" + id
                + ", reservationName='" + reservationName + '\''
                + '}';
    }

    public CodesOrders() {
        
     
    }

    public CodesOrders(String reservationName) {
        this.reservationName = reservationName;
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

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
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

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
    
    
    
    
    

    
}
