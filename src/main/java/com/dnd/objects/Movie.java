package com.dnd.objects;

import lombok.Getter;

import java.time.Duration;

@Getter
public class Movie {
    private final String title;
    private final Duration duration;
    private final Integer price;

    public Movie(String title, Duration duration, Integer price) {
        this.title = title;
        this.duration = duration;
        this.price = price;
    }
}
