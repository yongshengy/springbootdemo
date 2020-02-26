package local.test.springboot.redissession.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SessionHandler {

    @Value("${server.port}")
    private String port;

    @PostMapping("/set/{name}")
    public String set(@PathVariable("name") String name, HttpSession session){
        session.setAttribute("name",this.port+"："+name);
        return (String)session.getAttribute("name");
    }

    @GetMapping("/get")
    public String get(HttpSession session){
        return (String)session.getAttribute("name");
    }
}
