package com.dnd.objects;

import java.util.ArrayList;
import java.util.List;

public class DiscountPolicy {
    private final List<DiscountCondition> discountConditions = new ArrayList<>();

    public void addDiscountCondition(DiscountCondition discountCondition) {
        this.discountConditions.add(discountCondition);
    }
}
