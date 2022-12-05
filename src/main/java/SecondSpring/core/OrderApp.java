package SecondSpring.core;

import SecondSpring.core.member.Grade;
import SecondSpring.core.member.Member;
import SecondSpring.core.member.MemberService;
import SecondSpring.core.member.MemberServiceImpl;
import SecondSpring.core.order.Order;
import SecondSpring.core.order.OrderService;
import SecondSpring.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.CalculatePrice());
    }
}
