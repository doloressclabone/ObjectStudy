package com.example.objectstudy.bookingMovie;

import java.time.Duration;

public class PercentDiscountMovie extends Movie{
    private double percent;

    public PercentDiscountMovie(String title, Duration runningTime, Money fee, double percent, DiscountPolicy discountPolicy, DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountPolicy, discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(percent);
    }
}
