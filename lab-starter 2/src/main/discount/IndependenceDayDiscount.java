package main.discount;

import java.util.Calendar;

public class IndependenceDayDiscount implements Discountable{
    @Override
    public double applyDiscount(double amount) {
        Calendar today = Calendar.getInstance();

        double discountPercentage = 0;
        boolean is28 = today.get(Calendar.DAY_OF_MONTH) == 28 &&
                today.get(Calendar.MONTH) == Calendar.NOVEMBER;

        if(is28)
            discountPercentage = 0.1;

        return amount * (1 - discountPercentage);
    }
}
