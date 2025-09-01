package cabseervice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvoiceServiceTest {

    @Test
    void singleNormalRide() {
        InvoiceGenerator g = new InvoiceGenerator();
        double fare = g.calculateFare(2.0, 5, Ride.RideType.NORMAL);
        assertEquals(25.0, fare);
    }

    @Test
    void singlePremiumRide() {
        InvoiceGenerator g = new InvoiceGenerator();
        double fare = g.calculateFare(2.0, 5, Ride.RideType.PREMIUM);
        assertEquals(40.0, fare);
    }

    @Test
    void multipleRides_withMinFare() {
        InvoiceGenerator g = new InvoiceGenerator();
        Ride[] rides = {
                new Ride(2.0, 5, Ride.RideType.NORMAL),
                new Ride(0.1, 1, Ride.RideType.NORMAL)
        };
        assertEquals(30.0, g.calculateFare(rides));
    }

    @Test
    void invoiceSummaryCorrect() {
        InvoiceGenerator g = new InvoiceGenerator();
        Ride[] rides = {
                new Ride(2.0, 5, Ride.RideType.NORMAL),
                new Ride(0.1, 1, Ride.RideType.NORMAL)
        };
        InvoiceSummary expected = new InvoiceSummary(2, 30.0);
        assertEquals(expected, g.calculateInvoice(rides));
    }

    @Test
    void invoiceServiceByUserId() {
        InvoiceService service = new InvoiceService();
        String userId = "user1";
        Ride[] rides = {
                new Ride(2.0, 5, Ride.RideType.PREMIUM),
                new Ride(1.0, 2, Ride.RideType.NORMAL)
        };
        service.addRides(userId, rides);
        assertEquals(new InvoiceSummary(2, 52.0), service.getInvoice(userId));
    }
}
