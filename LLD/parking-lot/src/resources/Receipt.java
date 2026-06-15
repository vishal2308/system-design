package resources;

public class Receipt {
    private final PaymentStatus paymentStatus;
    private final int transactionId;
    private final int amount;
    private final String paymentMode;
    private final Vehicle vehicle;

    public Receipt(PaymentStatus paymentStatus, int transactionId, int amount, String paymentMode, Vehicle vehicle) {
        this.paymentStatus = paymentStatus;
        this.transactionId = transactionId;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.vehicle = vehicle;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("PaymentStatus: ").append(paymentStatus).append("\n");
        s.append("TransactionId: ").append(transactionId).append("\n");
        s.append("Amount: ").append(amount).append("\n");
        s.append("PaymentMode: ").append(paymentMode).append("\n");
        s.append("Vehicle: ").append(vehicle.toString()).append("\n");
        return s.toString();
    }
}
