package lib.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

import lib.server.controller.*;
import lib.server.usecase.*;
import lib.server.repository.*;
import lib.config.Config;
import lib.middleware.Auth;
import lib.entity.request.*;
import lib.entity.response.*;

@Configuration
@ComponentScan(basePackages = {"lib.config", "lib.server", "lib.middleware", "lib.entity"})
public class Modules {

    // ============ USER MODULE ============
    
    @Bean
    public lib.server.repository.User userRepository(Config config) {
        return new lib.server.repository.User(config);
    }
    
    @Bean
    public lib.server.usecase.User userUsecase(lib.server.repository.User userRepository, Config config) {
        return new lib.server.usecase.User(userRepository, config);
    }
    
    @Bean
    public lib.server.controller.User userController(lib.server.usecase.User userUsecase) {
        return new lib.server.controller.User(userUsecase);
    }
    
    // ============ GROUP MODULE ============
    
    @Bean(name = "groupRepository")
    public lib.server.repository.Group groupRepository(Config config) {
        return new lib.server.repository.Group(config);
    }
    
    @Bean(name = "groupUsecase")
    public lib.server.usecase.Group groupUsecase(lib.server.repository.Group groupRepository, Config config) {
        return new lib.server.usecase.Group(groupRepository, config);
    }
    
    @Bean(name = "groupController")
    public lib.server.controller.Group groupController(lib.server.usecase.Group groupUsecase) {
        return new lib.server.controller.Group(groupUsecase);
    }
    
    // ============ MEMBER MODULE ============
    
    @Bean(name = "memberRepository")
    public lib.server.repository.Member memberRepository(Config config) {
        return new lib.server.repository.Member(config);
    }
    
    @Bean(name = "memberUsecase")
    public lib.server.usecase.Member memberUsecase(lib.server.repository.Member memberRepository, Config config) {
        return new lib.server.usecase.Member(memberRepository, config);
    }
    
    @Bean(name = "memberController")
    public lib.server.controller.Member memberController(lib.server.usecase.Member memberUsecase) {
        return new lib.server.controller.Member(memberUsecase);
    }
    
    // ============ ROLE MODULE ============
    
    @Bean(name = "roleRepository")
    public lib.server.repository.Role roleRepository(Config config) {
        return new lib.server.repository.Role(config);
    }
    
    @Bean(name = "roleUsecase")
    public lib.server.usecase.Role roleUsecase(lib.server.repository.Role roleRepository, Config config) {
        return new lib.server.usecase.Role(roleRepository, config);
    }
    
    @Bean(name = "roleController")
    public lib.server.controller.Role roleController(lib.server.usecase.Role roleUsecase) {
        return new lib.server.controller.Role(roleUsecase);
    }
    
    // ============ MIDDLEWARE MODULE ============
    
    @Bean
    public Auth authMiddleware() {
        return new Auth();
    }
}