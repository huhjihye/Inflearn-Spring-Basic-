package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") //url 매칭
    public String hello(Model model){ //스프링이 모델을 만들어서 넣어줌
        model.addAttribute("data", "hello"); //key : data   값: hello
        return "hello";    //templates 아래에 있는   hello로 가라    templates/hello.html

        //컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버가 화면을 찾아서 처리한다.
        //즉 리턴값에 html 이름을 넣어주어야 한다.

    }


    //MVC : Model, View, Controller
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    //API
    @GetMapping("hello-string")
    @ResponseBody //Html body 태그가 아닌  -> http에서 헤더 바디 중에 바디에 데이터를 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //"hello spring"

    }

    //json 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    }
