package local.test.springboot.shopping.controller;

import local.test.springboot.shopping.entity.User;
import local.test.springboot.shopping.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private CartService cartService;
    @Autowired
    private AddressService addressService;

    @RequestMapping("/login")
    public String login(@RequestParam(name = "loginName", required = false) String loginName, @RequestParam(name="passWord", required = false) String passWord, HttpSession session, Model model){
        User user = userService.login(loginName, passWord);
        if(user == null){
            return "redirect:/login.html";
        }else{
            user.setCarts(cartService.findAllByUserId(user.getId()));
            session.setAttribute("user",user);
            return "redirect:/user/index";
        }
    }

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("list",productService.findAllProductCategory());
        modelAndView.addObject("news",newsService.findForMain());
        return modelAndView;
    }

    @RequestMapping("/findNewsByPage/{page}/{limit}")
    public ModelAndView findNewsByPage(@PathVariable("page") int page,@PathVariable("limit") int limit){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newsList");
        int pages = newsService.getPages(limit);
        if(page > pages){
            page = pages;
        }
        if(page == 0){
            page = 1;
        }
        modelAndView.addObject("list",newsService.findByPage(page, limit));
        modelAndView.addObject("pages",newsService.getPages(limit));
        modelAndView.addObject("page",page);
        return modelAndView;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }

    @RequestMapping("/findAllAddressByUserId")
    public ModelAndView findAllAddressByUserId(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userAddressList");
        User user = (User) session.getAttribute("user");
        modelAndView.addObject("list",addressService.findAllByUserId(user.getId()));
        return modelAndView;
    }

    @RequestMapping("/register")
    public String register(User user){
        userService.register(user);
        return "redirect:/login.jsp";
    }

    @RequestMapping("/userInfo")
    public String userInfo(){
        return "userInfo";
    }
}
