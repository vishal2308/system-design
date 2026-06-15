package service;

import exceptions.IllegalSpotState;
import exceptions.PaymentFailedException;
import resources.*;
import strategy.payment.PaymentMode;
import strategy.rent.RentStrategy;

public class ParkingService {
    private static int ticketCount = 0;
    private final ParkingLot parkingLot;

    public ParkingService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park (Vehicle vehicle, RentStrategy rentStrategy) {
        for (int i = 0; i < parkingLot.getFloorList().size(); i++) {
            try {
                Floor floor = parkingLot.getFloorList().get(i);
                Spot spot = floor.getSpotAllocation().allotSpot(SpotType.valueOf(vehicle.getVehicleType().name()));
                Ticket ticket = new Ticket(ticketCount, spot, vehicle, rentStrategy);
                System.out.println("Vehicle " + vehicle.getVehicleType().name() + " has been parked, Ticket details :" + ticket.toString());
                ticketCount++;
                return ticket;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage() + "on floor : " + parkingLot.getFloorList().get(i).getId());
            }
        }
        return null;
    }

    public Receipt unPark (Ticket ticket, PaymentMode paymentMode) {
        Spot spot = ticket.getSpot();
        Floor floor = parkingLot.getFloorList().get(spot.getFloorId());
        int fee = ticket.getRentStrategy().calculateRent(ticket);
        try {
            floor.getSpotAllocation().releaseOrAddSpot(spot);
            PaymentDetails paymentDetails = paymentMode.pay(fee);
            Receipt receipt = new Receipt(PaymentStatus.PAID, paymentDetails.getTransactionId(), paymentDetails.getAmount(), paymentDetails.getPaymentMode(), ticket.getVehicle());
            System.out.println("Vehicle " + ticket.getVehicle().getVehicleType().name() + " has been unparked, Receipt details :" + receipt.toString());
            return receipt;
        } catch (Exception e) {
            if (e instanceof PaymentFailedException) {
                //Revert the spot release, by allocating new spot
                System.out.println(e.getMessage());
            } else if (e instanceof IllegalSpotState) {
                System.out.println(e.getMessage());
            }
            throw e;
        }
    }
}