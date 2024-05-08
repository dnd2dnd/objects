package com.dnd.objects;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    private SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public static SequenceCondition from(int sequence) {
        return new SequenceCondition(sequence);
    }

    @Override
    public boolean checkDiscount(Screen screen) {
        return screen.getSequence() == sequence;
    }
}
