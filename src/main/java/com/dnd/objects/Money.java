package com.dnd.objects;

import lombok.Getter;

@Getter
public class Money {
	private final int money;

	private Money(int money) {
		this.money = money;
	}

	public static Money from(int money) {
		validateMoney(money);
		return new Money(money);
	}

	private static void validateMoney(int money) {
		if(money < 0) {
			throw new IllegalArgumentException("음수가 될 수 없음");
		}
	}

}
