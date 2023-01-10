package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") //url 매칭
    public String hello(Model model){ //스프링이 모델을 만들어서 넣어줌
        model.addAttribute("data", "hello"); //key : data   값: hello
        return "hello";    //templates 아래에 있는   hello로 가라    templates/hello.html

        //컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버가 화면을 찾아서 처리한다.
        //즉 리턴값에 html 이름을 넣어주어야 한다.

    }
}
