package resources;

import java.util.List;

public class ParkingLot {
    List<Floor> floorList;

    public ParkingLot(List<Floor> floorList) {
        this.floorList = floorList;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }
}