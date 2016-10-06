package lv.rtme.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Points {

    @Id
    @GeneratedValue
    private Long id;
    private String reservationName;
    
    private String pointType;
    private String pointName;
    private String pointCode;

    
    
    @Override
    public String toString() {
        return "A reservation{"
                + "id:" + id
                + ", reservationName='" + reservationName + '\''
                + '}';
    }

    
    
    public Points() {
    }

    public Points(String pointType, String pointName, String pointCode) {
        this.pointType = pointType;
        this.pointName = pointName;
        this.pointCode = pointCode;
    }
    

    public Points(String reservationName) {
        this.reservationName = reservationName;
    }

    public Long getId() {
        return id;
    }

    public String getReservationName() {
        return reservationName;
    }

    public String getPointType() {
        return pointType;
    }

    public void setPointType(String pointType) {
        this.pointType = pointType;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getPointCode() {
        return pointCode;
    }

    public void setPointCode(String pointCode) {
        this.pointCode = pointCode;
    }
    
    
}
