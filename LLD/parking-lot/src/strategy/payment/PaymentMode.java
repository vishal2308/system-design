package strategy.payment;

import resources.PaymentDetails;
import resources.Ticket;

public interface PaymentMode {
    PaymentDetails pay (int fee);
}