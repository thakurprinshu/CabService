package cabseervice;

import java.util.*;

public class RideRepository {
    private final Map<String, List<Ride>> userRides = new HashMap<>();

    public void addRides(String userId, Ride[] rides) {
        userRides.put(userId, Arrays.asList(rides));
    }

    public Ride[] getRides(String userId) {
        List<Ride> list = userRides.get(userId);
        if (list == null) return new Ride[0];
        return list.toArray(new Ride[0]);
    }
}

