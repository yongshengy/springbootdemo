package local.test.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHandler {

    @Value("${server.port}")
    private String port;

    // http://localhost:8080/index
    @GetMapping("/index")
    public String index() {
        return "Hello World!" + port;
    }
}
