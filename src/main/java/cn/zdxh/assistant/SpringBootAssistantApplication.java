package cn.zdxh.assistant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("cn.zdxh.assistant.mapper")
@SpringBootApplication
public class SpringBootAssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssistantApplication.class, args);
	}
}
