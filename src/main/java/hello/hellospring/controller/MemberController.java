package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;


    //위에 final 뺄 경우 사용
@Autowired
    public MemberController(MemberService memberService){
    this.memberService=memberService;
}

@GetMapping("/members/new") //url 조회할때 보통 get 사용
    public String createForm(){
    return "members/createMemberForm";
}
@PostMapping("/members/new")  //데이터를 전달할때 post
public String create(MemberForm form){   // MemberForm에서 만든 name
    Member member= new Member();
    member.setName(form.getName());

    memberService.join(member);

    return "redirect:/";
}


//회원 조회
    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

//    //의존 관계 주입
//    @Autowired //생성자 호출 -> MemberService에 있는 memberservice 연결해줌.
//    public MemberController(MemberService memberService) {
//
//        this.memberService = memberService;
//    }
}
