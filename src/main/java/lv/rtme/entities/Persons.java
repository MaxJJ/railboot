package lv.rtme.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Persons {

    @Id
    @GeneratedValue
    private Long id;
    private String reservationName;
    
    private String sampleName;
    private String details;
    
    private String searchName;

    @Override
    public String toString() {
      return "A reservation{"
                + "id:" + id
                + ", reservationName='" + searchName + '\''
                + '}';
    }

    public Persons() {
    }

    public Persons(String reservationName) {
        this.reservationName = reservationName;
    }

    public Long getId() {
        return id;
    }

    public String getReservationName() {
        return reservationName;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }
    
    
    
}
