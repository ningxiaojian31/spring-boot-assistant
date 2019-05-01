# spring-boot-assistant
新华生活小助手项目后端代码

1、该项目作为Spring Boot项目，内置Tomcat，端口为8090

2、相关建表请参考sql文件

3、数据持久层采用了Spring Data JPA + Mybatis，旨在探索两者的用法的不同，建议一般的查询用JPA，复杂的查询用mybatis,或者使用更加出色的Mybatis-Plus

4、不足之处：没加到异常处理机制、返回的json格式也没有做统一格式处理，有兴趣的可以自行增加

5、另一端为Android端，代码暂未上传

6、Android端的运行效果：

<img src="https://github.com/ningxiaojian31/spring-boot-assistant/blob/master/src/document/pic/%E5%9B%BE%E7%89%871.png" width="350px"></img>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://github.com/ningxiaojian31/spring-boot-assistant/blob/master/src/document/pic/%E5%9B%BE%E7%89%872.png" width="350px"></img>    

<img src="https://github.com/ningxiaojian31/spring-boot-assistant/blob/master/src/document/pic/%E5%9B%BE%E7%89%873.png" width="350px"></img>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://github.com/ningxiaojian31/spring-boot-assistant/blob/master/src/document/pic/%E5%9B%BE%E7%89%874.png" width="350px"></img> 

