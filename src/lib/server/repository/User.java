package lib.server.repository;

import lib.config.*;
import lib.entity.model.*;
import java.util.ArrayList;

interface UserRepositoryInterface {
    public ArrayList<lib.entity.model.User> SelectUsers();
    public int CountUsers();
    public lib.entity.model.User SelectUser(String id);
    public boolean InsertUser(lib.entity.model.User user);
    public boolean UpdateUser(String id, lib.entity.model.User user);
    public boolean DeleteUser(String id);
}

public class User implements UserRepositoryInterface{
    private final lib.config.Config applicationConfig;
    
    public ArrayList<lib.entity.model.User> SelectUsers(){
        // TODO: Implement database query
        return new ArrayList<lib.entity.model.User>();
    }

    public int CountUsers(){
        // TODO: Implement database count query
        return 0;
    }

    public lib.entity.model.User SelectUser(String id){
        // TODO: Implement database select by ID
        return new lib.entity.model.User();
    }

    public boolean InsertUser(lib.entity.model.User user){
        // TODO: Implement database insert
        return true;
    }

    public boolean UpdateUser(String id, lib.entity.model.User user){
        // TODO: Implement database update
        return true;
    }

    public boolean DeleteUser(String id){
        // TODO: Implement database delete
        return true;
    }

    public User(lib.config.Config applicationConfig) {
        this.applicationConfig = applicationConfig;
    }
}
