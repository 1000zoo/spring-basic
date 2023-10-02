package zoo.springbasic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import zoo.springbasic.discount.FixDiscountPolicy;
import zoo.springbasic.member.Grade;
import zoo.springbasic.member.Member;
import zoo.springbasic.member.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        // 순수 자바 코드로 테스트를 할 경우
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "item", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}