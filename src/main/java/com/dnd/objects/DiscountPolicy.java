package com.dnd.objects;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class DiscountPolicy {
    protected final List<DiscountCondition> discountConditions = new ArrayList<>();

    public void addDiscountCondition(DiscountCondition discountCondition) {
        this.discountConditions.add(discountCondition);
    }

	abstract int calculateDiscount(Screen screen);
}
