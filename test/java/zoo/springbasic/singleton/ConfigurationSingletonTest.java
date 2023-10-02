package zoo.springbasic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zoo.springbasic.AppConfig;
import zoo.springbasic.AutoAppConfig;
import zoo.springbasic.member.MemberRepository;
import zoo.springbasic.member.MemberServiceImpl;
import zoo.springbasic.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

    @Test
    @DisplayName("Configuration singleton 이 지켜지는지")
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        Assertions.assertThat(memberRepository).isSameAs(memberRepository1);
        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());
    }
}
