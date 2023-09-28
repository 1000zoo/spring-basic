package zoo.springbasic.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonServiceTest {

    // static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonServiceTest instance = new SingletonServiceTest();

    // 이 메서드를 통해서만 인스턴스를 받도록 한다.
    public static SingletonServiceTest getInstance() {
        return instance;
    }

    // 혹여나 외부에서 생성을 하지 못하도록 private 으로 생성자를 숨긴다.
    private SingletonServiceTest() {
        // private 생성자를 만들어
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
