package cabseervice;

public class InvoiceGenerator {

    private static final double NORMAL_COST_PER_KM = 10;
    private static final int NORMAL_COST_PER_MIN = 1;
    private static final double NORMAL_MIN_FARE = 5;

    private static final double PREMIUM_COST_PER_KM = 15;
    private static final int PREMIUM_COST_PER_MIN = 2;
    private static final double PREMIUM_MIN_FARE = 20;

    public double calculateFare(double distance, int time, Ride.RideType type) {
        double fare;
        if (type == Ride.RideType.NORMAL) {
            fare = distance * NORMAL_COST_PER_KM + time * NORMAL_COST_PER_MIN;
            return Math.max(fare, NORMAL_MIN_FARE);
        } else {
            fare = distance * PREMIUM_COST_PER_KM + time * PREMIUM_COST_PER_MIN;
            return Math.max(fare, PREMIUM_MIN_FARE);
        }
    }

    public double calculateFare(Ride[] rides) {
        double total = 0;
        for (Ride r : rides) {
            total += calculateFare(r.distance, r.time, r.rideType);
        }
        return total;
    }

    public InvoiceSummary calculateInvoice(Ride[] rides) {
        double total = calculateFare(rides);
        return new InvoiceSummary(rides.length, total);
    }
}

