package hello.servlet.web.frontcontroller.v3_2.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v3_2.ControllerV3_2;
import hello.servlet.web.frontcontroller.v3_2.ModelView;
import java.util.Map;

public class MemberSaveControllerV3_2 implements ControllerV3_2 {

  MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public ModelView process(Map<String, String> paramMap) {

    String username = paramMap.get("username");
    int age = Integer.parseInt(paramMap.get("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);

    ModelView modelView = new ModelView("save-result");
    modelView.getParamMap().put("member", member);

    return modelView;

  }
}
