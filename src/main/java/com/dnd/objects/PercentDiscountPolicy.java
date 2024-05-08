package com.dnd.objects;

public class PercentDiscountPolicy extends DiscountPolicy{
    private Double percent;

    private PercentDiscountPolicy(Double percent) {
        this.percent = percent;
    }

    public static PercentDiscountPolicy from(Double percent) {
        return new PercentDiscountPolicy(percent/100);
    }

    @Override
    int calculateDiscount(Screen screen) {
        int regularPrice = screen.getMovie().getPrice();
        int price = regularPrice;
        for (DiscountCondition discountCondition : discountConditions) {
            if(discountCondition.checkDiscount(screen)) {
                price = (int)Math.min(price, regularPrice - regularPrice * percent);
            }
        }
        return price;
    }
}
