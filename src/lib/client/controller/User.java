package lib.client.controller;

import lib.client.usecase.*;
import lib.config.*;

interface UserControllerInterface {
    public void GetUsers();   
    public void CreateUser();
    public void UpdateUser();
    public void DeleteUser();
}

public class User {
    public lib.client.usecase.User userUsecase;
    
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

    public User(lib.client.usecase.User userUsecase) {
        this.userUsecase = userUsecase;
    }
}

