package lib.server.controller;

interface GroupControllerInterface {
    public lib.entity.response.Group GetGroups();
    public lib.entity.response.Group CountGroups();
    public lib.entity.response.Group CreateGroup(lib.entity.request.Group groupRequest);
    public lib.entity.response.Group UpdateGroup(String id, lib.entity.request.Group groupRequest);
    public lib.entity.response.Group DeleteGroup(String id);
}

public class Group implements GroupControllerInterface{
    private final lib.server.usecase.Group groupUsecase;
    
    public Group(lib.server.usecase.Group groupUsecase) {
        this.groupUsecase = groupUsecase;
    }
   
    public lib.entity.response.Group GetGroups(){
        lib.entity.request.Group groupRequest = new lib.entity.request.Group();
        lib.entity.response.Group groupResponse = this.groupUsecase.GetGroups(groupRequest);
        return groupResponse;
    }

    public lib.entity.response.Group CountGroups(){
        lib.entity.request.Group groupRequest = new lib.entity.request.Group();
        lib.entity.response.Group groupResponse = new lib.entity.response.Group();
        groupResponse.setMessage("Count groups - TODO: implement in usecase");
        return groupResponse;
    }

    public lib.entity.response.Group CreateGroup(lib.entity.request.Group groupRequest){
        lib.entity.response.Group groupResponse = new lib.entity.response.Group();
        groupResponse.setMessage("Create group - TODO: implement in usecase");
        return groupResponse;
    }

    public lib.entity.response.Group UpdateGroup(String id, lib.entity.request.Group groupRequest){
        lib.entity.response.Group groupResponse = new lib.entity.response.Group();
        groupResponse.setMessage("Update group ID: " + id + " - TODO: implement in usecase");
        return groupResponse;
    }

    public lib.entity.response.Group DeleteGroup(String id){
        lib.entity.response.Group groupResponse = new lib.entity.response.Group();
        groupResponse.setMessage("Delete group ID: " + id + " - TODO: implement in usecase");
        return groupResponse;
    }
}