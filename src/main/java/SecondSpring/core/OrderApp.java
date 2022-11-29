package SecondSpring.core;

import SecondSpring.core.member.Grade;
import SecondSpring.core.member.Member;
import SecondSpring.core.member.MemberService;
import SecondSpring.core.member.MemberServiceImpl;
import SecondSpring.core.order.Order;
import SecondSpring.core.order.OrderService;
import SecondSpring.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.CalculatePrice());
    }
}
