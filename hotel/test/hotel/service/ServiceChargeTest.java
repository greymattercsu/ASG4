/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.service;

import hotel.entities.ServiceType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SANIL
 */
public class ServiceChargeTest {
    
    public ServiceChargeTest() {
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
     * Test of run method, of class RecordServiceCTL.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        RecordServiceCTL instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of roomNumberEntered method, of class RecordServiceCTL.
     */
    @Test
    public void testRoomNumberEntered() {
        System.out.println("roomNumberEntered");
        int roomNumber = 0;
        RecordServiceCTL instance = null;
        instance.roomNumberEntered(roomNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serviceDetailsEntered method, of class RecordServiceCTL.
     */
    @Test
    public void testServiceDetailsEntered() {
        System.out.println("serviceDetailsEntered");
        ServiceType serviceType = null;
        double cost = 0.0;
        RecordServiceCTL instance = null;
        instance.serviceDetailsEntered(serviceType, cost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancel method, of class RecordServiceCTL.
     */
    @Test
    public void testCancel() {
        System.out.println("cancel");
        RecordServiceCTL instance = null;
        instance.cancel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of completed method, of class RecordServiceCTL.
     */
    @Test
    public void testCompleted() {
        System.out.println("completed");
        RecordServiceCTL instance = null;
        instance.completed();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
