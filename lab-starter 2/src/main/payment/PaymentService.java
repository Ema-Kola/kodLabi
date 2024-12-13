package main.payment;

public class PaymentService {
    private final Logger logger;
    private final OperatorRate operatorRate;
    private final EmailSender emailSender;

    public PaymentService(Logger logger, OperatorRate operatorRate, EmailSender emailSender) {
        this.logger = logger;
        this.operatorRate = operatorRate;
        this.emailSender = emailSender;
    }

    public PaymentRequest createPaymentRequest(Sale sale, CreditCard creditCard) {
        logger.log("Creating payment for sale: " + sale);

        int feeRate = operatorRate.feeRate(creditCard.getCardNumber());
        float fee = (feeRate * sale.total()) / 100;

        PaymentRequest paymentRequest = new PaymentRequest(sale.total(), creditCard, fee);

        if (sale.total() >= 1000) {
            emailSender.send(paymentRequest);
        }
        return paymentRequest;
    }
}
