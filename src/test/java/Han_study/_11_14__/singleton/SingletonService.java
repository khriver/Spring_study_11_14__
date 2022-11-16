package Han_study._11_14__.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {
//    1. static 영역에 객체를 딱 1개만 생성
    private static final SingletonService instance = new SingletonService();

//    2. public으로 열어서 객체 인스턴스가 필요하면 이 static 매서드를 통해서면 조회하도록 허용
    public static SingletonService getInstance(){
        return instance;
    }
//    3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체생성을 못하게 막음.
    private SingletonService(){

    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
