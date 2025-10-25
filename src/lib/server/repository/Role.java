package lib.server.repository;

import java.util.ArrayList;

interface RoleRepositoryInterface {
    public ArrayList<lib.entity.model.Role> SelectRoles();
    public int CountRoles();
    public lib.entity.model.Role SelectRole(String id);
    public boolean InsertRole(lib.entity.model.Role role);
    public boolean UpdateRole(String id, lib.entity.model.Role role);
    public boolean DeleteRole(String id);
}

public class Role implements RoleRepositoryInterface{
    private final lib.config.Config applicationConfig;

    public Role(lib.config.Config applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    public ArrayList<lib.entity.model.Role> SelectRoles(){
        // TODO: Implement database query
        return new ArrayList<lib.entity.model.Role>();
    }

    public int CountRoles(){
        // TODO: Implement database count query
        return 0;
    }

    public lib.entity.model.Role SelectRole(String id){
        // TODO: Implement database select by ID
        return new lib.entity.model.Role();
    }

    public boolean InsertRole(lib.entity.model.Role role){
        // TODO: Implement database insert
        return true;
    }

    public boolean UpdateRole(String id, lib.entity.model.Role role){
        // TODO: Implement database update
        return true;
    }

    public boolean DeleteRole(String id){
        // TODO: Implement database delete
        return true;
    }
}