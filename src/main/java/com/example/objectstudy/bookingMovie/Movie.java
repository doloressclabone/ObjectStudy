package com.example.objectstudy.bookingMovie;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public abstract class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;
    private List<DiscountCondition> discountConditions;
    private MovieType movieType;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy,
                 DiscountCondition... discountConditions){
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
        this.discountConditions = Arrays.asList(discountConditions)
    }

    public Money getFee(){
        return fee;
    }

    public Money calculateMovieFee(Screening screening){
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    private boolean isDiscountable(Screening screening){
        return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    abstract protected Money calculateDiscountAmount();

    /*
    Movie avatar = new Movie("아바타",
            Duration.ofMinutes(120),
            Money.wons(15000),
            new AmountDiscountPolicy(Money.wons(800),
                    new SequenceCondition(1),
                    new SequenceCondition(10),
                    new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10,0), LocalTime.of(11,59)),
                    new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10,0), LocalTime.of(20,59))
                )
            );

    //10%의 비율 할인 정책과 두 개의 기간 조건과 한 개의 순서 조건.
    Movie titanic = new Movie("타이타닉",
            Duration.ofMinutes(180),
            Money.wons(15000),
            new PercentDiscountPolicy(0.1,
                new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14,0), LocalTime.of(16,59)),
                new SequenceCondition(2),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10,0), LocalTime.of(13,59))
            )
    );

    Movie starWars = new Movie("스타워즈",
            Duration.ofMinutes(210),
            Money.wons(15000),
            new NoneDiscountPolicy()
            );
     */
}
