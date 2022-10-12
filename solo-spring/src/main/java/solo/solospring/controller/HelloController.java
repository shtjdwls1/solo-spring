package solo.solospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }


    @GetMapping("/hello-string")
    @ResponseBody // http에서 헤더부와 바디부가 있는데 바디부에 내가 데이터를 직접 넣어주겠다라는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello "+name; // name에 spring이라고 넣으면 "hello spring"이라고 들어감
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    // 기본은 JSON으로 반환
    // @ResponseBody가 붙어있으면 데이터를 그대로 넘기는데 문자가 아니라 객체다
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
