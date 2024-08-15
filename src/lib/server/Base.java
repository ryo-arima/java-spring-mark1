package lib.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "lib.config")
@ComponentScan(basePackages = "lib.server.controller")
@ComponentScan(basePackages = "lib.server.usecase")
@ComponentScan(basePackages = "lib.server.repository")
public class Base {
   public void run(String[] args){
      SpringApplication application = new  SpringApplication(Base.class);
      application.setWebApplicationType(WebApplicationType.REACTIVE);
      application.setAllowBeanDefinitionOverriding(true);
      application.setAdditionalProfiles("debug");
      application.run(args);
   }
}
