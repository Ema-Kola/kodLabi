package main.payment;

public interface EmailSender {
    void send(PaymentRequest paymentRequest);
}
