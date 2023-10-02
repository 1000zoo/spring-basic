package zoo.springbasic.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import zoo.springbasic.discount.DiscountPolicy;
import zoo.springbasic.member.Member;
import zoo.springbasic.member.MemberRepository;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
