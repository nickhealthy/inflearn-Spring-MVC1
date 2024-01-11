package hello.servlet.web.frontcontroller.v3_2;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3_2.controller.MemberFormControllerV3_2;
import hello.servlet.web.frontcontroller.v3_2.controller.MemberListControllerV3_2;
import hello.servlet.web.frontcontroller.v3_2.controller.MemberSaveControllerV3_2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 안보고 2차 구현 연습
 */
@WebServlet(name = "frontControllerServletV3_2", urlPatterns = "/front-controller/v3_2/*")
public class FrontControllerServletV3_2 extends HttpServlet {

  private Map<String, ControllerV3_2> controllerMap = new HashMap<>();

  public FrontControllerServletV3_2() {
    controllerMap.put("/front-controller/v3_2/members/new-form", new MemberFormControllerV3_2());
    controllerMap.put("/front-controller/v3_2/members/save", new MemberSaveControllerV3_2());
    controllerMap.put("/front-controller/v3_2/members", new MemberListControllerV3_2());
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String requestURI = request.getRequestURI();
    ControllerV3_2 controller = controllerMap.get(requestURI);
    if (controller == null) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    // request로 들어온 파라미터를 Map에 담아 컨트롤러에 전달
    Map<String, String> paramMap = createParamMap(request);
    ModelView modelView = controller.process(paramMap);

    // viewResolver - 논리적인 뷰 이름을 물리적인 뷰 이름으로 변환
    MyView view = viewResolver(modelView);

    // 뷰 랜더링
    // 뷰 랜더링 시 뷰에 필요한 정보를 출력해주기 위해 Model을 넘긴다.
    view.render(modelView.getParamMap(), request, response);
  }

  private MyView viewResolver(ModelView modelView) {
    return new MyView("/WEB-INF/views/" + modelView.getViewName() + ".jsp");
  }

  private Map<String, String> createParamMap(HttpServletRequest request) {
    Map<String, String> paramMap = new HashMap<>();
    request.getParameterNames().asIterator()
        .forEachRemaining(param -> paramMap.put(param, request.getParameter(param)));

    return paramMap;
  }
}
