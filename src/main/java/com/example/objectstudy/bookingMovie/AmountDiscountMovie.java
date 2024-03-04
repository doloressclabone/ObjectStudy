package com.example.objectstudy.bookingMovie;

import java.time.Duration;

public class AmountDiscountMovie extends Movie{
    private Money discountAmount;

    public AmountDiscountMovie(String title, Duration runningTime, Money fee, Money discountAmount, DiscountPolicy discountPolicy, DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountPolicy, discountConditions);
        this.discountAmount = discountAmount
    }

    @Override
    protected Money calculateDiscountAmount(){
        return discountAmount;
    }
}
