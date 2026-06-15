package resources;


public class Vehicle {
    private final int id;
    private final VehicleType vehicleType;

    public Vehicle(int id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }
    public int getId() {
        return id;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public String toString() {
        return String.format("Vehicle[id=%d, type=%s]", id, vehicleType);
    }
}