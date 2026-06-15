package service;
import resources.*;
import strategy.allocation.NearestSpot;
import strategy.allocation.SpotAllocation;
import strategy.payment.PaymentMode;
import strategy.payment.UpiPay;
import strategy.rent.HourlyRentStartegy;
import strategy.rent.RentStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingMain {

    public static void main (String[] args) {
        SpotAllocation spotAllocation = new NearestSpot();
        Floor floorOne = new Floor(0, spotAllocation);
        int count = 0;
        for (SpotType type : SpotType.values()) {
            for (int j = 0; j < 5;  j++) {
                Spot spot = new Spot(count++ + 1, floorOne.getId(), type, j + 1, false);
                spotAllocation.releaseOrAddSpot(spot);
            }
        }
        List<Floor> floorList = new ArrayList<>(List.of(floorOne));
        ParkingLot parkingLot = new ParkingLot(floorList);
        ParkingService service = new ParkingService(parkingLot);
        RentStrategy rentStrategy = new HourlyRentStartegy();
        PaymentMode mode = new UpiPay();
        Ticket t1 = service.park(new Vehicle(1, VehicleType.BIKE), rentStrategy);
        Ticket t2 = service.park(new Vehicle(2, VehicleType.BIKE), rentStrategy);
        Ticket t3 = service.park(new Vehicle(3, VehicleType.BIKE), rentStrategy);
        Ticket t4 = service.park(new Vehicle(4, VehicleType.BIKE), rentStrategy);
        Ticket t5 = service.park(new Vehicle(5, VehicleType.BIKE), rentStrategy);
        Ticket t6 = service.park(new Vehicle(6, VehicleType.BIKE), rentStrategy);
        Receipt r1 = service.unPark(t1, mode);


    }
}