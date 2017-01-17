package com.railtransme.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class MyTool {

    @Id
    @GeneratedValue
    private Long id;
    private String reservationName;
    private String tag;
    @Lob
    private String item;

    @Override
    public String toString() {
        return "A reservation{"
                + "id:" + id
                + ", reservationName='" + reservationName + '\''
                + '}';
    }

    public MyTool() {
    }

    public MyTool(String reservationName) {
        this.reservationName = reservationName;
    }

    public Long getId() {
        return id;
    }
    
   

    public String getReservationName() {
        return reservationName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
    
}
