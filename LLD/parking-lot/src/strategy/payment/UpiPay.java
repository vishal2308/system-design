package strategy.payment;


import exceptions.PaymentFailedException;
import resources.*;

import java.util.*;

public class UpiPay implements PaymentMode {

    @Override
    public PaymentDetails pay (int fee) {
        try {
            Random random = new Random(System.currentTimeMillis());
            int transactionId = random.nextInt(1000);
            return new PaymentDetails(transactionId, fee, this.getClass().getName());
        } catch (RuntimeException e) {
            throw new PaymentFailedException("Payment Failed");
        }
    }
}