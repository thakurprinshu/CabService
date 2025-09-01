package cabseervice;

public class InvoiceService {
    private final RideRepository rideRepository = new RideRepository();
    private final InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoice(String userId) {
        Ride[] rides = rideRepository.getRides(userId);
        return invoiceGenerator.calculateInvoice(rides);
    }
}

