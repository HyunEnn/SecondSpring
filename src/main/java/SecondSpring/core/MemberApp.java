package SecondSpring.core;

import SecondSpring.core.member.Grade;
import SecondSpring.core.member.Member;
import SecondSpring.core.member.MemberService;
import SecondSpring.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP); // ctrl + alt + v
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member= " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    } // psvm
}
