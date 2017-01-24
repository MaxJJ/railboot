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
        CodesOrdersProperties instance = new CodesOrdersProperties();
        instance.setCodesOrders(orders);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");

        assertEquals("testCodesOrders", instance.getCo().getValue().getReservationName());
    }

    /**
     * Test of getCo method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetCo() {
        System.out.println("getCo");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        ObjectProperty<CodesOrders> expResult = null;
        ObjectProperty<CodesOrders> result = instance.getCo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdLongProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetIdLongProperty() {
        System.out.println("getIdLongProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        LongProperty expResult = null;
        LongProperty result = instance.getIdLongProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFileIdProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetFileIdProperty() {
        System.out.println("getFileIdProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        StringProperty expResult = null;
        StringProperty result = instance.getFileIdProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSearchStringProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetSearchStringProperty() {
        System.out.println("getSearchStringProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        StringProperty expResult = null;
        StringProperty result = instance.getSearchStringProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStationOfDispatchProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetStationOfDispatchProperty() {
        System.out.println("getStationOfDispatchProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
                StringProperty expResult = null;
        StringProperty result = instance.getStationOfDispatchProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDispatchStationObjectProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetDispatchStationObjectProperty() {
        System.out.println("getDispatchStationObjectProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        ObjectProperty<Station> expResult = null;
        ObjectProperty<Station> result = instance.getDispatchStationObjectProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStationOfDestinationProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetStationOfDestinationProperty() {
        System.out.println("getStationOfDestinationProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        StringProperty expResult = null;
        StringProperty result = instance.getStationOfDestinationProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDestinationStationObjectProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetDestinationStationObjectProperty() {
        System.out.println("getDestinationStationObjectProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        ObjectProperty<Station> expResult = null;
        ObjectProperty<Station> result = instance.getDestinationStationObjectProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsigneeProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetConsigneeProperty() {
        System.out.println("getConsigneeProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        StringProperty expResult = null;
        StringProperty result = instance.getConsigneeProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsigneeObjectProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetConsigneeObjectProperty() {
        System.out.println("getConsigneeObjectProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        ObjectProperty<Persons> expResult = null;
        ObjectProperty<Persons> result = instance.getConsigneeObjectProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomTagProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetCustomTagProperty() {
        System.out.println("getCustomTagProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        StringProperty expResult = null;
        StringProperty result = instance.getCustomTagProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCargoProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetCargoProperty() {
        System.out.println("getCargoProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        StringProperty expResult = null;
        StringProperty result = instance.getCargoProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeightProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetWeightProperty() {
        System.out.println("getWeightProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        StringProperty expResult = null;
        StringProperty result = instance.getWeightProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCargoWeightDoubleProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetCargoWeightDoubleProperty() {
        System.out.println("getCargoWeightDoubleProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        DoubleProperty expResult = null;
        DoubleProperty result = instance.getCargoWeightDoubleProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWagonProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetWagonProperty() {
        System.out.println("getWagonProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        StringProperty expResult = null;
        StringProperty result = instance.getWagonProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetUnitProperty() {
        System.out.println("getUnitProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        StringProperty expResult = null;
        StringProperty result = instance.getUnitProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContainerTareDoubleProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetContainerTareDoubleProperty() {
        System.out.println("getContainerTareDoubleProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        DoubleProperty expResult = null;
        DoubleProperty result = instance.getContainerTareDoubleProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCargoTotalGrossDoubleProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetCargoTotalGrossDoubleProperty() {
        System.out.println("getCargoTotalGrossDoubleProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        DoubleProperty expResult = null;
        DoubleProperty result = instance.getCargoTotalGrossDoubleProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProviderProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetProviderProperty() {
        System.out.println("getProviderProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        StringProperty expResult = null;
        StringProperty result = instance.getProviderProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRateProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetRateProperty() {
        System.out.println("getRateProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        StringProperty expResult = null;
        StringProperty result = instance.getRateProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRateDoubleProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetRateDoubleProperty() {
        System.out.println("getRateDoubleProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        DoubleProperty expResult = null;
        DoubleProperty result = instance.getRateDoubleProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRateCurrencyProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetRateCurrencyProperty() {
        System.out.println("getRateCurrencyProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        StringProperty expResult = null;
        StringProperty result = instance.getRateCurrencyProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGuardRateDoubleProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetGuardRateDoubleProperty() {
        System.out.println("getGuardRateDoubleProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        DoubleProperty expResult = null;
        DoubleProperty result = instance.getGuardRateDoubleProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGuardCurrencyProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetGuardCurrencyProperty() {
        System.out.println("getGuardCurrencyProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        StringProperty expResult = null;
        StringProperty result = instance.getGuardCurrencyProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoadsToPayProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetRoadsToPayProperty() {
        System.out.println("getRoadsToPayProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        StringProperty expResult = null;
        StringProperty result = instance.getRoadsToPayProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsOrderedProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetIsOrderedProperty() {
        System.out.println("getIsOrderedProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        BooleanProperty expResult = null;
        BooleanProperty result = instance.getIsOrderedProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsRequestedProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetIsRequestedProperty() {
        System.out.println("getIsRequestedProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        BooleanProperty expResult = null;
        BooleanProperty result = instance.getIsRequestedProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderedOnDateProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetOrderedOnDateProperty() {
        System.out.println("getOrderedOnDateProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        ObjectProperty<Date> expResult = null;
        ObjectProperty<Date> result = instance.getOrderedOnDateProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRequestedOnDateProperty method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetRequestedOnDateProperty() {
        System.out.println("getRequestedOnDateProperty");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        ObjectProperty<Date> expResult = null;
        ObjectProperty<Date> result = instance.getRequestedOnDateProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreviuosCodesOrders method, of class CodesOrdersProperties.
     */
    @Test
    public void testGetPreviuosCodesOrders() {
        System.out.println("getPreviuosCodesOrders");
        CodesOrdersProperties instance = new CodesOrdersProperties();
        ObjectProperty<CodesOrders> expResult = null;
        ObjectProperty<CodesOrders> result = instance.getPreviuosCodesOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
