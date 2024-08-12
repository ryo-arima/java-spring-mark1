package lib.client.controller;

import lib.client.usecase.*;

interface UserControllerInterface {
    public void GetUsers();   
    public void CreateUser();
    public void UpdateUser();
    public void DeleteUser();
}

public class UserController implements UserControllerInterface{
    UserUsecase userUsecase;
    
    public void GetUsers(){
        this.userUsecase.GetUsers();
    }

    public void CreateUser(){
        this.userUsecase.CreateUser();
    }

    public void UpdateUser(){
        this.userUsecase.UpdateUser();
    }

    public void DeleteUser(){
        this.userUsecase.DeleteUser();
    }

    public UserController(UserUsecase userUsecase) {
        this.userUsecase = userUsecase;
    }
}

