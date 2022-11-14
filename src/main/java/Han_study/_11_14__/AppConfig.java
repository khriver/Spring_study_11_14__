package Han_study._11_14__;

import Han_study._11_14__.discount.DiscountPolicy;
import Han_study._11_14__.discount.FixDiscountPolicy;
import Han_study._11_14__.discount.RateDiscountPolicy;
import Han_study._11_14__.member.MemberRepository;
import Han_study._11_14__.member.MemberService;
import Han_study._11_14__.member.MemberServiceImpl;
import Han_study._11_14__.member.MemoryMemberRepository;
import Han_study._11_14__.order.OrderService;
import Han_study._11_14__.order.OrderServiceImpl;

public class AppConfig {
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
