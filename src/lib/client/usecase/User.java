package lib.client.usecase;

import org.thymeleaf.context.Context;

interface UserUsecaseInterface {
    public void GetUsers();
    public void CreateUser();
    public void UpdateUser();
    public void DeleteUser();
}

public class User implements UserUsecaseInterface{
    public lib.client.repository.User userRepository;
    
    public void GetUsers(){
        lib.entity.request.User userRequest = new lib.entity.request.User();
        this.userRepository.GetUsers(userRequest);
        Context context = new Context();
        context.setVariable("name", "Thymeleaf");
        String output = this.userRepository.applicationConfig.appClientTemplateEngine.process("get_users", context);
        System.out.println(output);
    }

    public void CreateUser(){
        lib.entity.request.User userRequest = new lib.entity.request.User();
        this.userRepository.CreateUser(userRequest);
    }

    public void UpdateUser(){
        lib.entity.request.User userRequest = new lib.entity.request.User();
        this.userRepository.UpdateUser(userRequest);
    }

    public void DeleteUser(){
        lib.entity.request.User userRequest = new lib.entity.request.User();
        this.userRepository.DeleteUser(userRequest);
    }

    public User(lib.client.repository.User userRepository) {
        this.userRepository = userRepository;
    }
}
