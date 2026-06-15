package strategy.rent;

import resources.Ticket;

import java.security.*;
import java.time.Duration;
import java.time.Instant;

public class HourlyRentStartegy implements RentStrategy {
    private static final int HOURLY_CHARGE = 20;

    @Override
    public int calculateRent(Ticket ticket) {
        long hours = Duration.between(ticket.getEntryTime(), Instant.now()).toHours();
        return (int) (HOURLY_CHARGE * hours);
    }
}