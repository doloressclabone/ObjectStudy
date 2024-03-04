package com.example.objectstudy.bookingMovie;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
