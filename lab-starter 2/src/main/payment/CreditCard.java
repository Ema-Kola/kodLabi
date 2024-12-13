package main.payment;

public class CreditCard {

    private Customer customer;
	private String cardNumber;

    public CreditCard(Customer customer, String cardNumber) {
        this.customer = customer;
        this.cardNumber = cardNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
