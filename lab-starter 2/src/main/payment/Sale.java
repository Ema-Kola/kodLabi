package main.payment;

import java.util.List;

public record Sale(Customer customer, List<Item> items) {

    public float total() {
        float total = 0;
        for (Item item : items) {
            total += (item.getPrice() * item.getQuantity());
        }
        return total;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "customer=" + customer +
                ", items=" + items +
                '}';
    }
}
