package resources;

public class Spot {
    private final int id;
    private final int floorId;
    private final SpotType type;
    private final int distance;
    boolean isOccupied;

    public Spot(int id, int floorId, SpotType type, int distance, boolean isOccupied) {
        this.id = id;
        this.type = type;
        this.distance = distance;
        this.isOccupied = isOccupied;
        this.floorId = floorId;
    }

    public int getId() {
        return id;
    }

    public SpotType getType() {
        return type;
    }

    public int getDistance() {
        return distance;
    }

    public int getFloorId() {
        return floorId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Spot occupy(Spot spot) {
        spot.isOccupied = true;
        return spot;
    }

    public void release(Spot spot) {
        spot.isOccupied = false;
    }
}
