package lv.rtme.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class CodesOrders {

    @Id
    @GeneratedValue
    private Long id;
    
    private  String fileID;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Station stationOfDispatch;
    @OneToOne
    @PrimaryKeyJoinColumn
    private  Station stationOfDestination;
    
    
    
    
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

    
}
