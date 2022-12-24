package SecondSpring.core.autowired;

import SecondSpring.core.AutoAppConfig;
import SecondSpring.core.discount.DiscountPolicy;
import SecondSpring.core.member.Grade;
import SecondSpring.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class); // DiscountService 함수를 이용하기 위해서 변수 선언
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);

        int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");

        assertThat(rateDiscountPrice).isEqualTo(2000);
    }

    static class DiscountService { // DiscountPolicy import
        private final Map<String, DiscountPolicy> policyMap;  // fixDiscountPolicy, rateDiscountPolicy
        private final List<DiscountPolicy> policies; // Fix, rate

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) { // discountCode 가 policyMap에서 같은 이름의 string을 찾아서 가져옴
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price); // fix를 가져온 뒤에 fixDiscountPolicy`s discount 함수를 호출
        }
    }
}
