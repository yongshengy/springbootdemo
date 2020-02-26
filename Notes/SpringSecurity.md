1. Java领域常用的安全框架是Shiro和Spring Security
    - Shiro是轻量级，广泛使用；
    - Spring Security是比较重量级，但是功能更加强大，权限控制更加细化，还有和Spring整合比较好
2. spring-boot-starter-security
3. 因为Spring Security给所有的请求都添加了自动验证规则，必须是登录用户才能访问，否则到Spring Security默认的登录页面，默认用户名是user, 密码是Spring Security随机生成的字符串，控制台输出的。也可以在配置文件中配置spring security的时候指定。
4. 实际开发中，一般不会直接将权限和用户绑定，而是将权限给角色，再给用户添加角色；需要有WebSecurityConfigurerAdapter  集成具体的角色权限用户信息配置
5. 
