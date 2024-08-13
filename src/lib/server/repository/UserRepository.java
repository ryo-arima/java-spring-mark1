package lib.server.repository;

import lib.config.*;
import lib.entity.model.*;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

interface UserRepositoryInterface {
    ArrayList<User> GetUsers(User user);
}

@Repository
public class UserRepository implements UserRepositoryInterface{
    public ApplicationConfig applicationConfig;
    
    public ArrayList<User> GetUsers(User user){
        System.out.println("get users");
        return new ArrayList<User>();
    }

    public UserRepository(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }
}
