package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;


/**
 * HTTP 요청 데이터 - API 메시지 바디 - JSON
 *
 * JSON 형식으로 파싱할 수 있게 객체를 하나 추가
 */
@Getter
@Setter
public class HelloData {

    private String username;
    private int age;

}
