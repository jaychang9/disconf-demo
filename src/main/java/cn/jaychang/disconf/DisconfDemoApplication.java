package cn.jaychang.disconf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = {"classpath:spring-disconf.xml"})
@SpringBootApplication
public class DisconfDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisconfDemoApplication.class, args);
	}
}