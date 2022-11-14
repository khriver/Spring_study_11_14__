package Han_study._11_14__.orderservice;

import Han_study._11_14__.AppConfig;
import Han_study._11_14__.member.Grade;
import Han_study._11_14__.member.Member;
import Han_study._11_14__.member.MemberService;
import Han_study._11_14__.member.MemberServiceImpl;
import Han_study._11_14__.order.Order;
import Han_study._11_14__.order.OrderService;
import Han_study._11_14__.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
