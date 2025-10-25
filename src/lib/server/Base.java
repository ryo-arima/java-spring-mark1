package lib.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(Modules.class)
public class Base {
   public void run(String[] args){
      SpringApplication application = new  SpringApplication(Base.class);
      application.setWebApplicationType(WebApplicationType.REACTIVE);
      application.setAllowBeanDefinitionOverriding(true);
      application.setAdditionalProfiles("debug");
      application.run(args);
   }
}
