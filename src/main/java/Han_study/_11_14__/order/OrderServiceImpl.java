package Han_study._11_14__.order;

import Han_study._11_14__.discount.DiscountPolicy;
import Han_study._11_14__.discount.FixDiscountPolicy;
import Han_study._11_14__.discount.RateDiscountPolicy;
import Han_study._11_14__.member.Member;
import Han_study._11_14__.member.MemberRepository;
import Han_study._11_14__.member.MemberService;
import Han_study._11_14__.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
// 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
