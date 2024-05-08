package com.dnd.objects;

public class AmountDiscountPolicy extends DiscountPolicy{
    private Money amount;

    private AmountDiscountPolicy(Money amount) {
        this.amount = amount;
    }

    public static AmountDiscountPolicy from(Integer amount) {
        return new AmountDiscountPolicy(Money.from(amount));
    }

    @Override
    int calculateDiscount(Screen screen) {
        int regularPrice = screen.getMovie().getPrice();
        int price = regularPrice;
        for (DiscountCondition discountCondition : discountConditions) {
            if(discountCondition.checkDiscount(screen)) {
                price = Math.min(price, regularPrice - amount.getMoney());
            }
        }
        return price;
    }
}
