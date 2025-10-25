package lib.server.controller;

interface UserControllerInterface {
    public lib.entity.response.User GetUsers();
    public lib.entity.response.User CountUsers();
    public lib.entity.response.User CreateUser(lib.entity.request.User userRequest);
    public lib.entity.response.User UpdateUser(String id, lib.entity.request.User userRequest);
    public lib.entity.response.User DeleteUser(String id);
}

public class User implements UserControllerInterface {
    private final lib.server.usecase.User userUsecase;
   
    public lib.entity.response.User GetUsers(){
        lib.entity.request.User userRequest = new lib.entity.request.User();
        lib.entity.response.User userResponse = this.userUsecase.GetUsers(userRequest);
        return userResponse;
    }

    public lib.entity.response.User CountUsers(){
        lib.entity.request.User userRequest = new lib.entity.request.User();
        lib.entity.response.User userResponse = this.userUsecase.CountUsers(userRequest);
        return userResponse;
    }

    public lib.entity.response.User CreateUser(lib.entity.request.User userRequest){
        lib.entity.response.User userResponse = this.userUsecase.CreateUser(userRequest);
        return userResponse;
    }

    public lib.entity.response.User UpdateUser(String id, lib.entity.request.User userRequest){
        lib.entity.response.User userResponse = this.userUsecase.UpdateUser(id, userRequest);
        return userResponse;
    }

    public lib.entity.response.User DeleteUser(String id){
        lib.entity.request.User userRequest = new lib.entity.request.User();
        lib.entity.response.User userResponse = this.userUsecase.DeleteUser(id, userRequest);
        return userResponse;
    }

    public User(lib.server.usecase.User userUsecase) {
        this.userUsecase = userUsecase;
    }
}