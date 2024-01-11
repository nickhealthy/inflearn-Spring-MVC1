package hello.servlet.web.frontcontroller.v3_2.controller;

import hello.servlet.web.frontcontroller.v3_2.ControllerV3_2;
import hello.servlet.web.frontcontroller.v3_2.ModelView;
import java.util.Map;

public class MemberFormControllerV3_2 implements ControllerV3_2 {


  @Override
  public ModelView process(Map<String, String> paramMap) {
    return new ModelView("new-form");
  }
}
