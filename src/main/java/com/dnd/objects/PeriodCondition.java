package com.dnd.objects;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    private PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static PeriodCondition of(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        return new PeriodCondition(dayOfWeek, startTime, endTime);
    }

    @Override
    public boolean checkDiscount(Screen screen) {
        LocalDateTime screenDateTime = screen.getStartTime();
        LocalTime screenTime = screenDateTime.toLocalTime();
        return screenDateTime.getDayOfWeek().equals(dayOfWeek)
            && startTime.isBefore(screenTime)
            && screenTime.isBefore(endTime);
    }
}
