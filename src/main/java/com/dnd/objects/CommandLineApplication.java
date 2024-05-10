package com.dnd.objects;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineApplication implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		List<Movie> movies = new ArrayList<>();
		AmountDiscountPolicy amountDiscountPolicy = AmountDiscountPolicy.from(800);
		amountDiscountPolicy.addDiscountCondition(SequenceCondition.from(1));
		amountDiscountPolicy.addDiscountCondition(SequenceCondition.from(10));
		amountDiscountPolicy.addDiscountCondition(PeriodCondition.of(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0)));
		amountDiscountPolicy.addDiscountCondition(PeriodCondition.of(DayOfWeek.THURSDAY, LocalTime.of(18, 0), LocalTime.of(20, 0)));

		Movie movieA = new Movie("아바타", Duration.ofHours(2), Money.from(10000), amountDiscountPolicy);
		movies.add(movieA);

		PercentDiscountPolicy percentDiscountPolicy = PercentDiscountPolicy.from(10.0);
		percentDiscountPolicy.addDiscountCondition(PeriodCondition.of(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(17, 0)));
		percentDiscountPolicy.addDiscountCondition(PeriodCondition.of(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(14, 0)));
		amountDiscountPolicy.addDiscountCondition(SequenceCondition.from(2));

		Movie movieB = new Movie("타이타닉", Duration.ofMinutes(150), Money.from(20000), amountDiscountPolicy);
		movies.add(movieB);

		List<Screen> screens = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			Duration duration = Duration.ofSeconds(movieA.getDuration().getSeconds() * i);
			screens.add(Screen.of(movieA, i, LocalDateTime.of(2024, 5, 8, 6, 0).plus(duration)));
		}

		for(int i=1; i<=7; i++) {
			Duration duration = Duration.ofSeconds(movieB.getDuration().getSeconds() * i);
			screens.add(Screen.of(movieB, i, LocalDateTime.of(2024, 5, 8, 6, 0).plus(duration)));
		}

		for (int i=0; i<screens.size(); i++) {
			System.out.println("Screen Number " + i+1 + ", " + screens.get(i));
		}

		System.out.println("1 입력시 예약시작, 다른 단어 입력시 종료");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {

			try {
				int x = Integer.parseInt(br.readLine());
				if(x == 1) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					System.out.println("Screen Number, Person Number 입력");
					int screenNumber = Integer.parseInt(st.nextToken());
					int person = Integer.parseInt(st.nextToken());
					Screen screen = screens.get(screenNumber);
					int payment = screen.getMovie().getDiscountPolicy().calculateDiscount(screen);
					Reservation reservation = new Reservation(screen, person, payment);
					System.out.println(reservation);
				} else {
					break;
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
