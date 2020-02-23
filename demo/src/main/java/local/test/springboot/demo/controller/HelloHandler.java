package local.test.springboot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHandler {

    // http://localhost:8080/index
    @GetMapping("/index")
    public String index() {
        return "Hello World!";
    }
}
