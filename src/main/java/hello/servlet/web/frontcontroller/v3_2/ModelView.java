package hello.servlet.web.frontcontroller.v3_2;

import java.util.HashMap;
import java.util.Map;

public class ModelView {

  private String viewName;

  private Map<String, Object> paramMap = new HashMap<>();

  public ModelView(String viewName) {
    this.viewName = viewName;
  }

  public String getViewName() {
    return viewName;
  }

  public void setViewName(String viewName) {
    this.viewName = viewName;
  }

  public Map<String, Object> getParamMap() {
    return paramMap;
  }

  public void setParamMap(Map<String, Object> paramMap) {
    this.paramMap = paramMap;
  }
}
