package lib.client.usecase;

import lib.client.repository.UserRepository;
import lib.entity.request.UserRequest;

interface UserUsecaseInterface {
    public void GetUsers();
    public void CreateUser();
    public void UpdateUser();
    public void DeleteUser();
}

public class UserUsecase implements UserUsecaseInterface{
    private UserRepository userRepository;
    
    public void GetUsers(){
        UserRequest userRequest = new UserRequest();
        this.userRepository.GetUsers(userRequest);
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
