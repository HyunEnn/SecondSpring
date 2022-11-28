package SecondSpring.core.order;

import SecondSpring.core.discount.DiscountPolicy;
import SecondSpring.core.discount.FixDiscountPolicy;
import SecondSpring.core.member.Member;
import SecondSpring.core.member.MemberRepository;
import SecondSpring.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
