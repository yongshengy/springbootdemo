package local.test.springboot.thymeleaf.controller;

import local.test.springboot.thymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloHandler {

    @GetMapping("/index")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","张三");
        modelAndView.setViewName("index");
        modelAndView.addObject("score", 70);
        modelAndView.addObject("userId", 1);


        List<User> list = new ArrayList<>();
        list.add(new User(1, "zhang"));
        list.add(new User(2, "li"));
        modelAndView.addObject("list", list);

        modelAndView.addObject("src","spring.png");
        request.getSession().setAttribute("name","yyang");
        return modelAndView;
    }

    @PostMapping("/login")
    public String login(@RequestParam("userName") String username) {
        System.out.println(username);
        return "index";
    }
}
