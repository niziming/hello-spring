package cn.ziming.hello.spring;

import cn.ziming.hello.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    // 记录日志的类
    private static final Logger logger = LoggerFactory.getLogger(MyTest.class);

    public static void main(String[] args) {
        // IoC的实现依赖注入
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHi();
        // 信息
        logger.info("info级别的日志");
        // 调试级别的信息 例:查询出来的值
        logger.debug("debug级别的日志");
        // 警告级别的信息
        logger.warn("warn级别的日志");
        // 错误级别的信息
        logger.error("error级别的日志");

        String message = "测试";
        String message1 = "测试1";

        logger.info("message is : {} {}", message, message1);
        System.out.println(String.format("massage is : %s %s", message, message1));
    }
}
