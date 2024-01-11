package hello.servlet.web.frontcontroller.v3_2.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v3_2.ControllerV3_2;
import hello.servlet.web.frontcontroller.v3_2.ModelView;
import java.util.List;
import java.util.Map;

public class MemberListControllerV3_2 implements ControllerV3_2 {

  MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public ModelView process(Map<String, String> paramMap) {

    List<Member> members = memberRepository.findAll();
    ModelView modelView = new ModelView("members");
    modelView.getParamMap().put("members", members);

    return modelView;

  }
}
