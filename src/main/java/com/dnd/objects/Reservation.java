package com.dnd.objects;

public class Reservation {
	private Screen screen;
	private int person;
	private Money regularPrice;
	private Money payment;

	public Reservation(Screen screen, int person) {
		this.screen = screen;
		this.person = person;
		this.regularPrice = Money.from(screen.getMovie().getPrice() * person);
		this.payment = payment;
	}

}
