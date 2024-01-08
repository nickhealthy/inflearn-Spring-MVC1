package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;


/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 *
 * 2. 동일한 파라미터 전송 가능
 * http://localhost:8080/request-param?username=hello&username=kim&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    /*
        request.getParameter()는 GET URL 쿼리 파라미터 형식도 지원하고,
        POST HTML Form 형식도 지원한다.

        GET URL 쿼리 파라미터 형식으로 클라이언트에서 서버로 데이터를 전달할 땐 HTTP 메시지 바디를 사용하지 않기 때문에 content-type이 없다.(null)
        POST HTML Form 형식으로 데이터를 전달함녀 HTTP 메시지 바디에 해당 데이터를 포함해서 보내기 때문에 바디에 포함된 데이터가 어떤 형식인지 content-type을 꼭 지정해야 한다.
        이렇게 폼으로 데이터를 전송하는 형식을 'application/x-www-form-urlencoded' 라고 한다.
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - start");

        // 옛날 방식
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String paramName = parameterNames.nextElement();
//            System.out.println("paramName = " + paramName);
//        }

        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(
                                "paramName = " + paramName));

        // 파라미터를 Map으로 조회
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            System.out.println("stringEntry.getKey() = " + stringEntry.getKey());
            System.out.println("stringEntry.getValue() = " + Arrays.toString(stringEntry.getValue()));

        }

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        System.out.println("request.getParameter(username) = " + username);

        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }


        response.getWriter().write("OK");

    }
}
