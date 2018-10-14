/**
 * This class is designed for the test case of bug 1(All Service charges are reported as 0.00 when checking out).
 */
package hotel.test;

import hotel.checkin.CheckinCTL;
import hotel.checkout.CheckoutCTL;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;
import hotel.entities.RoomType;
import hotel.entities.ServiceType;
import hotel.service.RecordServiceCTL;
import java.util.Date;
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
public class Bug1Test {

    public Bug1Test() {
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
     * So to test All Service charges are reported as 0.00 when checking out ,
     * first I have booked the room, then checked in, then recorded service (Service type: room service with cost 20) and finally
     * check out and try to record service to the same room programatically.
     */
    @Test
    public void testZeroServiceCharge() {
        System.out.println("Test All Service charges are reported as 0.00 when checking out.");
        Hotel hotel = new Hotel();

        /*------------ for booking -------------*/
        System.out.println("************booking start*************");
        Guest guest = new Guest("name1", "address1", 1123456);
        Date arrivalDate = new Date();
        int stayLength = 2;
        int numberOfOccupants = 2;
        CreditCard creditCard = new CreditCard(CreditCardType.VISA, 1, 2);
        Room room = new Room(1, RoomType.SINGLE);
        Booking booking = room.book(guest, arrivalDate, stayLength, numberOfOccupants, creditCard);//method call and assign to variable that books the room.
        //booking.checkIn();
        hotel.book(room, guest, arrivalDate, 2, 1, creditCard); //creates the confirmation number for bookingss

        long confNumber = booking.getConfirmationNumber();
        System.out.println("************booking end*************");
        /*------------ for booking end -------------*/
 /*------------ for checkin -------------*/
        System.out.println("************checkin start*************");
        CheckinCTL checkin = new CheckinCTL(hotel);
        checkin.confirmationNumberEntered(confNumber);
        checkin.checkInConfirmed(true);
        System.out.println("************checkin end*************");
        /*------------ check in end -------------*/
 /*------------ record service start -------------*/
        System.out.println("************record service start*************");
        RecordServiceCTL recordServiceCTL = new RecordServiceCTL(hotel);
        recordServiceCTL.roomNumberEntered(room.getId());

        System.out.println("State before method call: " + recordServiceCTL.getState());
        ServiceType serviceType = ServiceType.ROOM_SERVICE;
        double cost = 20.0;
        recordServiceCTL.serviceDetailsEntered(serviceType, cost);
        System.out.println("State after method call: " + recordServiceCTL.getState());
        System.out.println("************record service end*************");
        /*------------ record service END -------------*/
 /*------------ check out start -------------*/
        System.out.println("************check out start*************");
        CheckoutCTL checkoutCTL = new CheckoutCTL(hotel);
        checkoutCTL.setState();
        checkoutCTL.roomIdEntered(room.getId());
        checkoutCTL.completed();
        hotel.checkout(room.getId());
        System.out.println("************check out finished*************");
    }

}
