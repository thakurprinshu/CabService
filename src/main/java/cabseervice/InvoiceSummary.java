package cabseervice;

import java.util.Objects;

public class InvoiceSummary {
    private final int totalRides;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int totalRides, double totalFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFare = totalFare / totalRides;
    }

    public int getTotalRides() { return totalRides; }
    public double getTotalFare() { return totalFare; }
    public double getAverageFare() { return averageFare; }

    @Override
    public String toString() {
        return "InvoiceSummary{" +
                "totalRides=" + totalRides +
                ", totalFare=" + totalFare +
                ", averageFare=" + averageFare +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceSummary)) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return totalRides == that.totalRides
                && Double.compare(that.totalFare, totalFare) == 0
                && Double.compare(that.averageFare, averageFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRides, totalFare, averageFare);
    }
}

