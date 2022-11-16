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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration // java기반의 config //singleton 컨테이너를 유지시켜주는 아주 마법의 어노테이션!!!!!!!!
public class AppConfig {
    //@Bean memberRepository -> new MemoryMemberRepository()
    //@Bean orderService     -> new MemoryMemberRepository()

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
