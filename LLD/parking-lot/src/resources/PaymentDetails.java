package resources;

import strategy.payment.PaymentMode;

public class PaymentDetails {
    private int transactionId;
    private int amount;
    private String paymentMode;
    public PaymentDetails (int transactionId, int amount, String paymentMode) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.paymentMode = paymentMode;
    }
    public int getTransactionId() {
        return transactionId;
    }
    public int getAmount() {
        return amount;
    }
    public String getPaymentMode() {
        return paymentMode;
    }
}
