package Han_study._11_14__.singleton;

import Han_study._11_14__.AppConfig;
import Han_study._11_14__.member.MemberRepository;
import Han_study._11_14__.member.MemberServiceImpl;
import Han_study._11_14__.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        //호출을 3번이나 헀는데 같은 인스턴스 생성
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository =  " + memberRepository1);
        System.out.println("orderService -> memberRepository =  " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

    }
}
