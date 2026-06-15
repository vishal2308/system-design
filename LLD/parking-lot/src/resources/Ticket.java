package resources;

import strategy.rent.RentStrategy;
import java.time.Instant;

public class Ticket {
    private final int id;
    private final Spot spot;
    private final Instant entryTime;
    private final Vehicle vehicle;
    private final RentStrategy rentStrategy;

    public Ticket(int id, Spot spot, Vehicle vehicle, RentStrategy rentStrategy) {
        this.id = id;
        this.spot = spot;
        this.entryTime = Instant.now();
        this.vehicle = vehicle;
        this.rentStrategy = rentStrategy;
    }

    public Spot getSpot() {
        return spot;
    }

    public RentStrategy getRentStrategy() {
        return rentStrategy;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Ticket ID: " + id + "\n");
        s.append("Spot ID: " + spot.getId() + "\n");
        s.append("Vehicle ID: " + vehicle.getId() + "\n");
        s.append("Ticket Date: " + entryTime.toString() + "\n");
        s.append("RentStrategy : " + rentStrategy.getClass().getName() + "\n" );
        return s.toString();
    }

}