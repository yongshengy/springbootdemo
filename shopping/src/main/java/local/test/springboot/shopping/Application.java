package local.test.springboot.shopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("local.test.springboot.shopping.repository")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
