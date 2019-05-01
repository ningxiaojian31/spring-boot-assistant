# spring-boot-assistant
新华生活小助手项目后端代码

1、该项目作为Spring Boot项目，内置Tomcat，端口为8090

2、相关建表请参考sql文件

3、数据持久层采用了Spring Data JPA + Mybatis，旨在探索两者的用法的不同，建议一般的查询用JPA，复杂的查询用mybatis,或者使用更加出色的Mybatis-Plus

4、不足之处：没加到异常处理机制、返回的json格式也没有做统一格式处理，有兴趣的可以自行增加

5、另一端为Android端，代码暂未上传

6、Android端的运行效果：

![image]E:\QQPCmgr\Desktop\图片1.png

![image](E:\QQPCmgr\Desktop\图片2.png)

![image](E:\QQPCmgr\Desktop\图片3.png)

![image](E:\QQPCmgr\Desktop\图片4.png)

