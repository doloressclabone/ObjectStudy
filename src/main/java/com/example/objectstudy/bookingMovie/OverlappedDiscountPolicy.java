package com.example.objectstudy.bookingMovie;

import java.util.Arrays;
import java.util.List;

public class OverlappedDiscountPolicy implements DiscountPolicy {

    private List<DiscountPolicy> discountPolicies;

    public OverlappedDiscountPolicy(DiscountPolicy ... discountPolicies){
        this.discountPolicies = Arrays.asList(discountPolicies);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        Money result = Money.ZERO;
        for (DiscountPolicy each : discountPolicies) {
            result = result.plus(each.calculateDiscountAmount(screening));
        }
        return result;
    }

}
