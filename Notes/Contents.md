1. 简介
    - Spring是设计层面的框架，但是Spring框架的配置非常繁琐，因此诞生了Spring Boot。
    - Spring Boot对常用的第三方库提供了配置方案，可以很好的整合Spring，如MyBatis, Spring JPA
    - 优势：
        - 不需要任何配置文件
        - 内嵌Web服务器，不需要额外配置
        - 默认支持JSON数据，不需要额外配置
        - 支持Restful风格
        - 最少一个配置文件就可以配置所有的个性化信息
    - 简单说，SpringBoot就是一个可以用最少的配置快速搭建Spring应用的框架，并且很好的集成第三方框架，快速开发。

2. 创建Spring Boot工程
    - 在线创建 https://start.spring.io, 可以Maven Gradle，Java，Ketlin Groovy， Spring Boot版本，GA，依赖的模块。
    - Idea Spring Initializr
    - 手动创建：空的Maven工程，parent标签配置spring-boot-starter-parent，然后在dependencies中添加需要的模块

3. 使用Spring Boot
    - 使用上面的三种方式的任一种创建Spring Boot工程
    - 比如Spring MVC依赖的工程，这里不需要web.xml中配置DispatcherServlet，同时不需要创建springmvc.xml
    - 传统的Spring MVC工程是添加三个配置，启动注解驱动，自动扫包，视图解析器。Spring Boot解决了前两个，第三个需要手动配置。
        - 正常的Handler，创建启动类Application, @SpringBootApplication - SpringApplication.run(Application.class, args);
        - 这里开启了自动化配置，同时完成了自动扫包，默认的范围是该类的所有子包和的当前包。
