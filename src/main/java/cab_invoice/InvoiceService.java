package cab_invoice;
// step 4 Invoice Service
public class InvoiceService {
    public final RideRepository rideRepository = new RideRepository();

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInVoiceSummary(String userId) {
        Ride rides[] = rideRepository.getRideDetails(userId);
        if (rides == null)
            throw new IllegalArgumentException("No rides found for user: " + userId);
        return Ride.getInvoiceSummary(rides);
    }
}
