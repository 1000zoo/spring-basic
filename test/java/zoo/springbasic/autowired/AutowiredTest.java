package zoo.springbasic.autowired;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import zoo.springbasic.member.Member;

import java.util.Optional;

public class AutowiredTest {

    @Test
    @DisplayName("자동주입 옵션 테스트 1")
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false)
        public void setNoBean01(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired()
        public void setNoBean02(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired()
        public void setNoBean03(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }


    }

}
