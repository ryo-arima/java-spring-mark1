package lib.server.controller;

import lib.server.usecase.*;
import lib.config.*;
import lib.entity.request.UserRequest;
import lib.entity.response.UserResponse;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

interface UserControllerForPrivateInterface {
    public UserResponse GetUsers();   
}

@RestController
@RequestMapping("/api/private") 
public class UserControllerForPrivate implements UserControllerForPrivateInterface{
    public UserUsecase userUsecase;
   
    @GetMapping("/users")
    public UserResponse GetUsers(){
        UserRequest userRequest = new UserRequest();
        UserResponse userResponse = this.userUsecase.GetUsers(userRequest);
        return userResponse;
    }

    public UserControllerForPrivate(UserUsecase userUsecase) {
        this.userUsecase = userUsecase;
    }
}

