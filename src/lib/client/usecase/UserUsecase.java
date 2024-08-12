package lib.client.usecase;

import lib.client.repository.UserRepository;
import lib.entity.request.UserRequest;
import org.thymeleaf.context.Context;
import lib.config.*;

interface UserUsecaseInterface {
    public void GetUsers();
    public void CreateUser();
    public void UpdateUser();
    public void DeleteUser();
}

public class UserUsecase implements UserUsecaseInterface{
    public UserRepository userRepository;
    
    public void GetUsers(){
        UserRequest userRequest = new UserRequest();
        this.userRepository.GetUsers(userRequest);
        Context context = new Context();
        context.setVariable("name", "Thymeleaf");
        String output = this.userRepository.applicationConfig.appClientTemplateEngine.process("get_users", context);
        System.out.println(output);
    }

    public void CreateUser(){
        UserRequest userRequest = new UserRequest();
        this.userRepository.CreateUser(userRequest);
    }

    public void UpdateUser(){
        UserRequest userRequest = new UserRequest();
        this.userRepository.UpdateUser(userRequest);
    }

    public void DeleteUser(){
        UserRequest userRequest = new UserRequest();
        this.userRepository.DeleteUser(userRequest);
    }

    public UserUsecase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
