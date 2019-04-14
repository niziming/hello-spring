---
title: 初识Spring
catalog: true
date: 2019-04-14 12:57:08
subtitle:
header-img:
tags: [Spring]

---

### Spring简介

Spring 是于 2003 年兴起的一个轻量级的 Java 开发框架，它是为了解决企业应用开发的复杂性而创建的。Spring 的核心是控制反转（IoC）和面向切面编程（AOP）。简单来说，Spring 是一个分层的 Java SE/EE full-stack (一站式) 轻量级开源框架。

Spring 的主要作用就是为代码 “解耦”，降低代码间的耦合度。

根据功能的不同，可以将一个系统中的代码分为 主业务逻辑 与 系统级业务逻辑 两类。它们各自具有鲜明的特点：主业务代码间逻辑联系紧密，有具体的专业业务应用场景，复用性相对较低；系统级业务相对功能独立，没有具体的专业业务应用场景，主要是为主业务提供系统级服务，如日志、安全、事务等，复用性强。

Spring 根据代码的功能特点，将降低耦合度的方式分为了两类：IoC 与 AOP。IoC 使得主业务在相互调用过程中，不用再自己维护关系了，即不用再自己创建要使用的对象了。而是由 Spring 容器统一管理，自动 “注入”。而 AOP 使得系统级服务得到了最大复用，且不用再由程序员手工将系统级服务 “混杂” 到主业务逻辑中了，而是由 Spring 容器统一完成 “织入”。
Spring也叫胶水框架.
conclusion:Spring是为了解决企业及开发的复杂度问题.

### 系统开发过程中

- 主业务逻辑
  - 银行业务
  - 保险业务
  - 电商业务
  - 物流业余
- 系统业务逻辑,交叉业务逻辑
  - JDBC连接驱动
    - 加载驱动		- 创建连接
    - 开启事物
    - SQL 操作 具体业务
    - 提交事物
    - 释放连接

### 解耦方式Ioc与AOP

- IoC:
  IoC 使得主>业务在相互调用过程中，不用再自己维护关系了，即不用再自己创建要使用的对象了。而是由Spring容器统一管理，自动“注入”。
  -例如:
  未使用Spring:自己使用Java创建对象时需要:UserService userService = new UserServiceImpl();
  使用Spring:而Spring可以由SpringOA容器创建
- AOP:
  使得系统级服务得到了最大复用，且不用再由程序员手工将系统级服务 “混杂” 到主业务逻辑中了，而是由 Spring 容器统一完成 “织入”。

### Spring体系结构

概述
Spring 由 20 多个模块组成，它们可以分为数据访问 / 集成（Data Access/Integration）、Web、面向切面编程（AOP, Aspects）、应用服务器设备管理（Instrumentation）、消息发送（Messaging）、核心容器（Core Container）和测试（Test）。
架构图:
{% asset_img spring-overview.png This is an spring-overview.png image %}

解释:

- Data Access/Intergration
  - JDBC 为spring的JDBC 
  - ORM 对象关系映射
    - MyBatis 建议主要学习这个
    - Hibernate
    - BeetlSQL
- Web层
  - WebSocket
  - web 
    - 例子:SpringMVC
  - Portlet 
    - 例子: 组合header section footer完成组件拼接
- AOP:面向切面编程 
  - Aspects框架完成面向切面编程
- Core Container核心容器
  - Beans
  - Core
  - Context
  - SpEL

### Spring的特点

#### 非侵入式

所谓的非侵入式,Spring 框架的 API 不会在业务逻辑上出现,即业务逻辑是 POJO。由于业务逻辑中没有 Spring 的 API，所以业务逻辑可以从 Spring 框架快速的移植到其他框架，OB即与环境无关。

侵入式例子:
​	Java Web
​		Servlet javax.servlet-api
​			extends HttpServlet

#### 容器container

#### IoC

#### AOP

是OOP的补充,面向切面编程.

### Spring与IoC

#### 概述

控制反转（IoC，Inversion of Control），是一个概念，是一种思想。指将传统上由程序代码直接操控的对象调用权交给容器，通过容器来实现对象的装配和管理。控制反转就是对对象控制权的转移，从程序代码本身反转到了外部容器。

IoC 是一个概念，是一种思想，其实现方式多种多样。当前比较流行的实现方式有两种： 依赖注入和依赖查找。依赖注入方式应用更为广泛。

- 依赖查找：Dependency Lookup，DL，容器提供回调接口和上下文环境给组件，程序代码则需要提供具体的查找方式。比较典型的是依赖于 JNDI 系统的查找。
- 依赖注入：Dependency Injection，DI，程序代码不做定位查询，这些工作由容器自行完成。 
  依赖注入 DI 是指程序运行过程中，若需要调用另一个对象协助时，无须在代码中创建被调用者，而是依赖于外部容器，由外部容器创建后传递给程序。

Spring 的依赖注入对调用者与被调用者几乎没有任何要求，完全支持 POJO 之间依赖关系的管理。

依赖注入是目前最优秀的解耦方式。依赖注入让 Spring 的 Bean 之间以配置文件的方式组织在一起，而不是以硬编码的方式耦合在一起的。

conclusion:硬编码指直接把代码写上去.例如实例化一个user对象new User();

### 第一个Spring应用程序

POM
创建一个名为hello-spring的项目,pom.xml文件如下:
Maven pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.funtl</groupId>
    <artifactId>hello-spring</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>4.3.17.RELEASE</version>
        </dependency>
    </dependencies>
</project>
```
在java下创建cn.ziming.hello.spring包后创建service,创建UserService接口,然后创建impl包实现UserService
~~~ java
public interface UserService {
    public void sayHi();
}
~~~
UserServiceImpl.java
~~~ java
@Override
    public void sayHi() {
        System.out.printf("Hello Spring");
    }
~~~
配置spring-contex.xml
~~~ xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="userService" class="cn.ziming.hello.spring.service.impl.UserServiceImpl" />

</beans>
~~~

测试类MyTest.java
~~~ java
public class MyTest {
    public static void main(String[] args) {
        // IoC的实现依赖注入
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHi();
    }
}
~~~

运行结果
~~~ log
四月 14, 2019 2:29:59 下午 org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
信息: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@179d3b25: startup date [Sun Apr 14 14:29:59 CST 2019]; root of context hierarchy
四月 14, 2019 2:29:59 下午 org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
信息: Loading XML bean definitions from class path resource [spring-context.xml]
Hello Spring
Process finished with exit code 0
~~~
### 参考资料

> Spring简介
> https://www.bilibili.com/video/av29299488/?p=27
> Spring
> https://www.funtl.com/zh/spring/#%E6%9C%AC%E8%8A%82%E8%A7%86%E9%A2%91