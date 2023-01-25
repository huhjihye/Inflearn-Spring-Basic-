package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private MemberService memberService;


    //위에 final 뺄 경우 사용
@Autowired
    public void setMemberService(MemberService memberService){
    this.memberService=memberService;
}


//    //의존 관계 주입
//    @Autowired //생성자 호출 -> MemberService에 있는 memberservice 연결해줌.
//    public MemberController(MemberService memberService) {
//
//        this.memberService = memberService;
//    }
}
