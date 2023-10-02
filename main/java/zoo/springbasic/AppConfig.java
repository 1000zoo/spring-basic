package zoo.springbasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zoo.springbasic.discount.DiscountPolicy;
import zoo.springbasic.discount.RateDiscountPolicy;
import zoo.springbasic.member.MemberRepository;
import zoo.springbasic.member.MemberService;
import zoo.springbasic.member.MemberServiceImpl;
import zoo.springbasic.member.MemoryMemberRepository;
import zoo.springbasic.order.OrderService;
import zoo.springbasic.order.OrderServiceImpl;

@Configuration
public class AppConfig {
//
//    @Bean
//    public MemberService memberService() {
//        return new MemberServiceImpl(getMemberRepository());
//    }
//
//    @Bean
//    public OrderService orderService() {
//        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
//
//    }
//
//    @Bean
//    public DiscountPolicy getDiscountPolicy() {
//        return new RateDiscountPolicy();
//    }
//
//    @Bean
//    public MemberRepository getMemberRepository() {
//        return new MemoryMemberRepository();
//    }
}
