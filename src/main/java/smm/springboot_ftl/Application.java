package smm.springboot_ftl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

import smm.springboot_ftl.action.UserController;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication 
@EnableAutoConfiguration 
public class Application {
	
	public static void main(String[] args){
		SpringApplication.run(Application.class,args);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setLocation("D:\\Program Files\\apache-tomcat-8.5.40\\webapps\\temp");//指定临时文件路径，这个路径可以随便写
		return factory.createMultipartConfig();
	}
	}
