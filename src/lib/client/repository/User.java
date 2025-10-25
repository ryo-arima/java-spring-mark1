package lib.client.repository;

import lib.config.*;
import lib.entity.request.*;
import lib.entity.response.*;

interface UserRepositoryInterface {
    lib.entity.response.User GetUsers(lib.entity.request.User userRequest);
    lib.entity.response.User CreateUser(lib.entity.request.User userRequest);
    lib.entity.response.User UpdateUser(lib.entity.request.User userRequest);
    lib.entity.response.User DeleteUser(lib.entity.request.User userRequest); 
}

public class User {
    public Config applicationConfig;
    
    public lib.entity.response.User GetUsers(lib.entity.request.User userRequest){
        System.out.println("get users");
        return new lib.entity.response.User("GET_USERS_FAILED", 200, null);
    }

    public lib.entity.response.User CreateUser(lib.entity.request.User userRequest){
        System.out.println("create user");
        return new lib.entity.response.User("CREATE_USER_FAILED", 201, null);
    }

    public lib.entity.response.User UpdateUser(lib.entity.request.User userRequest){
        System.out.println("update user");
        return new lib.entity.response.User("UPDATE_USER_FAILED", 200, null);
    }

    public lib.entity.response.User DeleteUser(lib.entity.request.User userRequest){
        System.out.println("delete user");
        return new lib.entity.response.User("DELETE_USER_FAILED", 200, null);
    }

    public User(Config applicationConfig) {
        this.applicationConfig = applicationConfig;
    }
}
