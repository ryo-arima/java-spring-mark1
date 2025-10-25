package lib.server.usecase;

import java.util.ArrayList;

interface UserUsecaseInterface {
    public lib.entity.response.User GetUsers(lib.entity.request.User userRequest);
    public lib.entity.response.User CountUsers(lib.entity.request.User userRequest);
    public lib.entity.response.User CreateUser(lib.entity.request.User userRequest);
    public lib.entity.response.User UpdateUser(String id, lib.entity.request.User userRequest);
    public lib.entity.response.User DeleteUser(String id, lib.entity.request.User userRequest);
}

public class User implements UserUsecaseInterface {
    private final lib.server.repository.User userRepository;
    private final lib.config.Config applicationConfig;

    public lib.entity.response.User GetUsers(lib.entity.request.User userRequest) {
        ArrayList<lib.entity.model.User> users = this.userRepository.SelectUsers();
        lib.entity.response.User userResponse = new lib.entity.response.User();
        userResponse.setMessage("Users retrieved successfully");
        userResponse.setCode(200);
        userResponse.setUsers(users);
        return userResponse;
    }

    public lib.entity.response.User CountUsers(lib.entity.request.User userRequest) {
        int count = this.userRepository.CountUsers();
        lib.entity.response.User userResponse = new lib.entity.response.User();
        userResponse.setMessage("Users count: " + count);
        userResponse.setCode(200);
        return userResponse;
    }

    public lib.entity.response.User CreateUser(lib.entity.request.User userRequest) {
        lib.entity.model.User user = new lib.entity.model.User();
        boolean success = this.userRepository.InsertUser(user);
        
        lib.entity.response.User userResponse = new lib.entity.response.User();
        if (success) {
            userResponse.setMessage("User created successfully");
            userResponse.setCode(201);
        } else {
            userResponse.setMessage("Failed to create user");
            userResponse.setCode(500);
        }
        return userResponse;
    }

    public lib.entity.response.User UpdateUser(String id, lib.entity.request.User userRequest) {
        lib.entity.model.User user = new lib.entity.model.User();
        boolean success = this.userRepository.UpdateUser(id, user);
        
        lib.entity.response.User userResponse = new lib.entity.response.User();
        if (success) {
            userResponse.setMessage("User updated successfully");
            userResponse.setCode(200);
        } else {
            userResponse.setMessage("Failed to update user");
            userResponse.setCode(500);
        }
        return userResponse;
    }

    public lib.entity.response.User DeleteUser(String id, lib.entity.request.User userRequest) {
        boolean success = this.userRepository.DeleteUser(id);
        
        lib.entity.response.User userResponse = new lib.entity.response.User();
        if (success) {
            userResponse.setMessage("User deleted successfully");
            userResponse.setCode(200);
        } else {
            userResponse.setMessage("Failed to delete user");
            userResponse.setCode(500);
        }
        return userResponse;
    }

    public User(lib.server.repository.User userRepository, lib.config.Config applicationConfig) {
        this.userRepository = userRepository;
        this.applicationConfig = applicationConfig;
    }
}
