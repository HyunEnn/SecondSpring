package SecondSpring.core.discount;

import SecondSpring.core.annotation.MainDiscountPolicy;
import SecondSpring.core.member.Grade;
import SecondSpring.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPolicy = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP)
            return price * discountPolicy / 100;
        else
            return 0;
    }
}
