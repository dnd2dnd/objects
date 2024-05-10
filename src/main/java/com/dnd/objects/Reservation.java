package com.dnd.objects;

import lombok.ToString;

@ToString
public class Reservation {
	private Screen screen;
	private int person;
	private Money regularPrice;
	private Money payment;

	public Reservation(Screen screen, int person, int payment) {
		this.screen = screen;
		this.person = person;
		this.regularPrice = Money.from(screen.getMovie().getPrice() * person);
		this.payment = Money.from(payment);
	}

}
