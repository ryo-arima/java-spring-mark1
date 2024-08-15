package lib.client.repository;

import lib.config.*;
import lib.entity.request.*;
import lib.entity.response.*;

interface UserRepositoryInterface {
    UserResponse GetUsers(UserRequest userRequest);
    UserResponse CreateUser(UserRequest userRequest);
    UserResponse UpdateUser(UserRequest userRequest);
    UserResponse DeleteUser(UserRequest userRequest); 
}

public class UserRepository implements UserRepositoryInterface{
    public ApplicationConfig applicationConfig;
    
    public UserResponse GetUsers(UserRequest userRequest){
        System.out.println("get users");
        return new UserResponse("GET_USERS_FAILED", "success", null);
    }

    public UserResponse CreateUser(UserRequest userRequest){
        System.out.println("create user");
        return new UserResponse("CREATE_USER_FAILED", "success", null);
    }

    public UserResponse UpdateUser(UserRequest userRequest){
        System.out.println("update user");
        return new UserResponse("UPDATE_USER_FAILED", "success", null);
    }

    public UserResponse DeleteUser(UserRequest userRequest){
        System.out.println("delete user");
        return new UserResponse("DELETE_USER_FAILED", "success", null);
    }

    public UserRepository(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }
}
