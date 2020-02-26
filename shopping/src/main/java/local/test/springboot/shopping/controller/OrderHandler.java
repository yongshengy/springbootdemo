package local.test.springboot.shopping.controller;

import local.test.springboot.shopping.entity.User;
import local.test.springboot.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/findByUser")
    public ModelAndView findByUser(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orderList");
        modelAndView.addObject("list",orderService.findByUserId(user.getId()));
        return modelAndView;
    }
}
