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
import javafx.beans.property.StringProperty;
import lv.rtme.entities.CodesOrders;
import lv.rtme.entities.Persons;
import lv.rtme.entities.Station;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class CodesOrdersPropertiesTest {
    
    public CodesOrdersPropertiesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setCodesOrders method, of class CodesOrdersProperties.
     */
    @Test
    public void testSetCodesOrders() {
        System.out.println("setCodesOrders");
        CodesOrders orders = new CodesOrders("testCodesOrders");
        Station stationOfDispatch = new Station("testStation dispatch");
        Station stationOfDestination = new Station("testStation destination");
        orders.setStationOfDispatch(stationOfDispatch);
        orders.setStationOfDestination(stationOfDestination);
        CodesOrdersProperties instance = new CodesOrdersProperties();
        instance.setCodesOrders(orders);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");


        assertEquals("testCodesOrders", instance.getCo().getValue().getReservationName());
        assertNotNull(instance.getCo());
        assertEquals("testStation dispatch", instance.getCo().getValue().getStationOfDispatch().getReservationName());
        
    }

    
}
