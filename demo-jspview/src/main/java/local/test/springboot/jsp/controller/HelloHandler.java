package local.test.springboot.jsp.controller;

import local.test.springboot.jsp.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloHandler {

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "zhang");
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> list = new ArrayList<>();
        list.add(new User(1L,"张三",1));
        list.add(new User(2L,"李四",0));
        list.add(new User(3L,"王五",1));
        modelAndView.addObject("list",list);
        modelAndView.setViewName("show");
        return modelAndView;
    }

}
