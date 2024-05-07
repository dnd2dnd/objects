package com.dnd.objects;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Screen {
    private Movie movie;
    private LocalDate startDate;
    private LocalDate endDate;
    private final Set<LocalTime> times = new TreeSet<>();

    private Screen(Movie movie, LocalDate startDate, LocalDate endDate) {
        this.movie = movie;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Screen of(Movie movie, LocalDate startDate, LocalDate endDate) {
        return new Screen(movie, startDate, endDate);
    }

    public void updateMove(Movie movie) {
        this.movie = movie;
    }

    public void updateDate(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addTime(LocalTime localTime) {
        this.times.add(localTime);
    }

    public void removeTime(LocalTime localTime) {
        this.times.remove(localTime);
    }
}
