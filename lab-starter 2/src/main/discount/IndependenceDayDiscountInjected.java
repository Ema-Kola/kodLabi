package main.discount;

import java.util.Calendar;

public class IndependenceDayDiscountInjected implements Discountable {
    private final Day day;
    public IndependenceDayDiscountInjected(Day day) {
        this.day = day;
    }
    @Override
    public double applyDiscount(double amount) {
        Calendar today = day.today();
        double discountPercentage = 0;
        boolean is28 = today.get(Calendar.DAY_OF_MONTH) == 28 &&
                today.get(Calendar.MONTH) == Calendar.NOVEMBER;
        if(is28)
            discountPercentage = 0.1;
        return amount * (1 - discountPercentage);
    }

}
