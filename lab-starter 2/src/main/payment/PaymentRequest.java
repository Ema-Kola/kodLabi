package main.payment;

public class PaymentRequest {

    private float total;
    private CreditCard creditCard;
    private float fee;

    public PaymentRequest() {
    }

    public PaymentRequest(float total, CreditCard creditCard, float fee) {
        this.total = total;
        this.creditCard = creditCard;
        this.fee = fee;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }
}
