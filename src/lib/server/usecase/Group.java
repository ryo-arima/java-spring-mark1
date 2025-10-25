package lib.server.usecase;

import java.util.ArrayList;

interface GroupUsecaseInterface {
    public lib.entity.response.Group GetGroups(lib.entity.request.Group groupRequest);
    public lib.entity.response.Group CountGroups(lib.entity.request.Group groupRequest);
    public lib.entity.response.Group CreateGroup(lib.entity.request.Group groupRequest);
    public lib.entity.response.Group UpdateGroup(String id, lib.entity.request.Group groupRequest);
    public lib.entity.response.Group DeleteGroup(String id, lib.entity.request.Group groupRequest);
}

public class Group implements GroupUsecaseInterface{
    private final lib.server.repository.Group groupRepository;
    private final lib.config.Config applicationConfig;
    
    public Group(lib.server.repository.Group groupRepository, lib.config.Config applicationConfig) {
        this.groupRepository = groupRepository;
        this.applicationConfig = applicationConfig;
    }

    public lib.entity.response.Group GetGroups(lib.entity.request.Group groupRequest){
        ArrayList<lib.entity.model.Group> groups = this.groupRepository.SelectGroups();
        lib.entity.response.Group groupResponse = new lib.entity.response.Group();
        groupResponse.setMessage("Groups retrieved successfully");
        groupResponse.setCode(200);
        groupResponse.setGroups(groups);
        return groupResponse;
    }

    public lib.entity.response.Group CountGroups(lib.entity.request.Group groupRequest){
        int count = this.groupRepository.CountGroups();
        lib.entity.response.Group groupResponse = new lib.entity.response.Group();
        groupResponse.setMessage("Groups count: " + count);
        groupResponse.setCode(200);
        return groupResponse;
    }

    public lib.entity.response.Group CreateGroup(lib.entity.request.Group groupRequest){
        // TODO: Convert request to model and validate
        lib.entity.model.Group group = new lib.entity.model.Group();
        boolean success = this.groupRepository.InsertGroup(group);
        
        lib.entity.response.Group groupResponse = new lib.entity.response.Group();
        if (success) {
            groupResponse.setMessage("Group created successfully");
            groupResponse.setCode(201);
        } else {
            groupResponse.setMessage("Failed to create group");
            groupResponse.setCode(500);
        }
        return groupResponse;
    }

    public lib.entity.response.Group UpdateGroup(String id, lib.entity.request.Group groupRequest){
        lib.entity.model.Group group = new lib.entity.model.Group();
        boolean success = this.groupRepository.UpdateGroup(id, group);
        
        lib.entity.response.Group groupResponse = new lib.entity.response.Group();
        if (success) {
            groupResponse.setMessage("Group updated successfully");
            groupResponse.setCode(200);
        } else {
            groupResponse.setMessage("Failed to update group");
            groupResponse.setCode(500);
        }
        return groupResponse;
    }

    public lib.entity.response.Group DeleteGroup(String id, lib.entity.request.Group groupRequest){
        boolean success = this.groupRepository.DeleteGroup(id);
        
        lib.entity.response.Group groupResponse = new lib.entity.response.Group();
        if (success) {
            groupResponse.setMessage("Group deleted successfully");
            groupResponse.setCode(200);
        } else {
            groupResponse.setMessage("Failed to delete group");
            groupResponse.setCode(500);
        }
        return groupResponse;
    }
}