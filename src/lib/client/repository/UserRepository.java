package lib.client.repository;

import lib.config.*;
import lib.entity.request.*;
import lib.entity.response.*;

interface UserRepositoryInterface {
    UserRespose GetUsers(UserRequest userRequest);
    UserRespose CreateUser(UserRequest userRequest);
    UserRespose UpdateUser(UserRequest userRequest);
    UserRespose DeleteUser(UserRequest userRequest); 
}

public class UserRepository implements UserRepositoryInterface{
    public ApplicationConfig applicationConfig;
    
    public UserRespose GetUsers(UserRequest userRequest){
        System.out.println("get users");
        return new UserRespose();
    }

    public UserRespose CreateUser(UserRequest userRequest){
        System.out.println("create user");
        return new UserRespose();
    }

    public UserRespose UpdateUser(UserRequest userRequest){
        System.out.println("update user");
        return new UserRespose();
    }

    public UserRespose DeleteUser(UserRequest userRequest){
        System.out.println("delete user");
        return new UserRespose();
    }

    public UserRepository(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }
}
