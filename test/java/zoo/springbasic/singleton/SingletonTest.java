package zoo.springbasic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zoo.springbasic.AppConfig;
import zoo.springbasic.member.MemberService;
import zoo.springbasic.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        assertThat(memberService1).isNotSameAs(memberService2);
    }


    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonServiceTest instance1 = SingletonServiceTest.getInstance();
        SingletonServiceTest instance2 = SingletonServiceTest.getInstance();

        assertThat(instance1).isSameAs(instance2);
    }

    @Test
    @DisplayName("싱글톤 컨테이너 테스트")
    void singletonContainerTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService1 = ac.getBean("memberService", MemberServiceImpl.class);
        MemberServiceImpl memberService2 = ac.getBean("memberService", MemberServiceImpl.class);

        assertThat(memberService1).isSameAs(memberService2);
    }
}
