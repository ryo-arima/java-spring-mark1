package lib.server.repository;

import java.util.ArrayList;

interface GroupRepositoryInterface {
    public ArrayList<lib.entity.model.Group> SelectGroups();
    public int CountGroups();
    public lib.entity.model.Group SelectGroup(String id);
    public boolean InsertGroup(lib.entity.model.Group group);
    public boolean UpdateGroup(String id, lib.entity.model.Group group);
    public boolean DeleteGroup(String id);
}

public class Group implements GroupRepositoryInterface{
    private final lib.config.Config applicationConfig;
    
    public Group(lib.config.Config applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    public ArrayList<lib.entity.model.Group> SelectGroups(){
        // TODO: Implement database query
        return new ArrayList<lib.entity.model.Group>();
    }

    public int CountGroups(){
        // TODO: Implement database count query
        return 0;
    }

    public lib.entity.model.Group SelectGroup(String id){
        // TODO: Implement database select by ID
        return new lib.entity.model.Group();
    }

    public boolean InsertGroup(lib.entity.model.Group group){
        // TODO: Implement database insert
        return true;
    }

    public boolean UpdateGroup(String id, lib.entity.model.Group group){
        // TODO: Implement database update
        return true;
    }

    public boolean DeleteGroup(String id){
        // TODO: Implement database delete
        return true;
    }
}