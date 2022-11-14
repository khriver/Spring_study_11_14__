package Han_study._11_14__.discount;

import Han_study._11_14__.member.Grade;
import Han_study._11_14__.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return discountFixAmount;
        } else{
            return 0;
        }
    }
}
