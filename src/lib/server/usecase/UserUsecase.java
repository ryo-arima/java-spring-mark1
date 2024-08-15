package lib.server.usecase;

import lib.server.repository.UserRepository;
import lib.entity.request.UserRequest;
import lib.entity.response.UserResponse;
import lib.entity.model.User;
import lib.config.*;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;

interface UserUsecaseInterface {
    public UserResponse GetUsers(UserRequest userRequest);
}

@Component
public class UserUsecase implements UserUsecaseInterface{
    public UserRepository userRepository;
    
    public UserResponse GetUsers(UserRequest userRequest){
        User userModel = new User();
        UserResponse userResponse = new UserResponse("GET_USERS_FAILED", "success", null);
        ArrayList<User> users = this.userRepository.GetUsers(userModel);
        userResponse.setUsers(users);
        return userResponse;
    }

    public UserUsecase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
