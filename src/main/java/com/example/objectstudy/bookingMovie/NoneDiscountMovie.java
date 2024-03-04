package com.example.objectstudy.bookingMovie;

import java.time.Duration;

public class NoneDiscountMovie extends Movie{
    public NoneDiscountMovie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy, DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountPolicy, discountConditions);
    }

    @Override
    protected Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}
