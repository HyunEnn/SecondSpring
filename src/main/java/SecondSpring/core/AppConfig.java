package SecondSpring.core;

import SecondSpring.core.discount.DiscountPolicy;
import SecondSpring.core.discount.FixDiscountPolicy;
import SecondSpring.core.discount.RateDiscountPolicy;
import SecondSpring.core.member.MemberRepository;
import SecondSpring.core.member.MemberService;
import SecondSpring.core.member.MemberServiceImpl;
import SecondSpring.core.member.MemoryMemberRepository;
import SecondSpring.core.order.OrderService;
import SecondSpring.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    } // MemberSeriveImpl에서 저장소, 구현한 저장소 (인터페이스, 클래스)에 의존하는 것이 아닌 인터페이스에만 의존적인 형태로 만듦.

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), getDiscountPolicy());
    }

    @Bean
    public DiscountPolicy getDiscountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
