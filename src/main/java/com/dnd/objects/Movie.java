package com.dnd.objects;

import lombok.Getter;
import lombok.ToString;

import java.time.Duration;

@Getter
@ToString
public class Movie {
    private final String title;
    private final Duration duration;
    private final Money price;
    private final DiscountPolicy discountPolicy;

    public Movie(String title, Duration duration, Money price, DiscountPolicy discountPolicy) {
        this.title = title;
        this.duration = duration;
        this.price = price;
		this.discountPolicy = discountPolicy;
	}

	public int getPrice() {
		return price.getMoney();
	}

	public int getDiscountPrice() {
		discountPolicy.get
	}
}
