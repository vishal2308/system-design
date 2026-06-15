package strategy.rent;

import resources.Ticket;

public interface RentStrategy {
    int calculateRent(Ticket ticket);
}