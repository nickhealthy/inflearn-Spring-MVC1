package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 어댑터 핸들러
 * <p>
 * 프론트 컨트롤러에서 호출되어 적절한 컨트롤러를 반환한다.
 */
public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    // 어댑터가 해당 컨트롤러를 처리할 수 있는지 판단하는 메서드
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    // 어댑터는 실제 컨트롤러를 호출하고, 그 결과로 ModelView 반환
    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws ServletException, IOException {

        ControllerV3 controller = (ControllerV3) handler;

        Map<String, String> paramMap = createParamMap(request);

        ModelView modelView = controller.process(paramMap);

        return modelView;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(param -> paramMap.put(param, request.getParameter(param)));

        return paramMap;
    }
}
