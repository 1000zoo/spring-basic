package zoo.springbasic.order;

import zoo.springbasic.discount.DiscountPolicy;
import zoo.springbasic.discount.FixDiscountPolicy;
import zoo.springbasic.member.Member;
import zoo.springbasic.member.MemberRepository;
import zoo.springbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

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
}
