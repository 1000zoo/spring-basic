package zoo.springbasic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zoo.springbasic.AutoAppConfig;
import zoo.springbasic.member.Grade;
import zoo.springbasic.member.Member;
import zoo.springbasic.member.MemberService;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        memberService = ac.getBean(MemberService.class);
        orderService = ac.getBean(OrderService.class);
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);
    }
}
