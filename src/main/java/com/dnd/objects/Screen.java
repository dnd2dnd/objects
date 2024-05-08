package com.dnd.objects;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Screen {
    private Movie movie;
    private int sequence;
    private LocalDateTime startTime;

    private Screen(Movie movie, int sequence, LocalDateTime startTime) {
        this.movie = movie;
        this.sequence = sequence;
        this.startTime = startTime;
    }

    public static Screen of(Movie movie, int sequence, LocalDateTime startTime) {
        return new Screen(movie, sequence, startTime);
    }

}
