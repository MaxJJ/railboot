package lv.rtme.entities;

import java.io.File;
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
    
    private String customTag;
    
    @Lob
    private String cargo;
    private String weight;
    private Double cargoWeightDouble;
    
    private String wagon;
    private String unit;
    private Double containerTare;
    private Double cargoTotalGross;
    
    private String provider;
    private String rate;
    private Double rateDouble;
    private String rateCurrency;
    private Double guardRate;
    private String guardCurrency;
    private String roadsToPay;
    
    private Double totalRate;
    
    private boolean isOrdered;
    private boolean isRequested;
    
    private Date orderedOnDate;
    private Date requestedOnDate;
    
    private File fileFilder;

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

    public Double getGuardRate() {
        return guardRate;
    }

    public void setGuardRate(Double guardRate) {
        this.guardRate = guardRate;
    }

    public String getGuardCurrency() {
        return guardCurrency;
    }

    public void setGuardCurrency(String guardCurrency) {
        this.guardCurrency = guardCurrency;
    }

    public Double getContainerTare() {
        return containerTare;
    }

    public void setContainerTare(Double containerTare) {
        this.containerTare = containerTare;
    }

    public String getCustomTag() {
        return customTag;
    }

    public void setCustomTag(String customTag) {
        this.customTag = customTag;
    }

    public Double getCargoWeightDouble() {
        return cargoWeightDouble;
    }

    public void setCargoWeightDouble(Double cargoWeightDouble) {
        this.cargoWeightDouble = cargoWeightDouble;
    }

    public Double getCargoTotalGross() {
        return cargoTotalGross;
    }

    public void setCargoTotalGross(Double cargoTotalGross) {
        this.cargoTotalGross = cargoTotalGross;
    }

    public Double getRateDouble() {
        return rateDouble;
    }

    public void setRateDouble(Double rateDouble) {
        this.rateDouble = rateDouble;
    }

    public Double getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(Double totalRate) {
        this.totalRate = totalRate;
    }

    public boolean isIsRequested() {
        return isRequested;
    }

    public void setIsRequested(boolean isRequested) {
        this.isRequested = isRequested;
    }

    public Date getRequestedOnDate() {
        return requestedOnDate;
    }

    public void setRequestedOnDate(Date requestedOnDate) {
        this.requestedOnDate = requestedOnDate;
    }

    public File getFileFilder() {
        return fileFilder;
    }

    public void setFileFilder(File fileFilder) {
        this.fileFilder = fileFilder;
    }

  
    
    
    
    
    

    
}
