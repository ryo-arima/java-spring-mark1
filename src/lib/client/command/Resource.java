package lib.client.command;

public class Resource {
    public Resource() {}
    
    void BootstrapUserCmdCall(String[] args){
        new lib.client.command.bootstrap.User(args);
    }
    
    void GetUsersCmdCall(String[] args){
        new lib.client.command.get.User(args);
    }
    
    void CreateUserCmdCall(String[] args){
        new lib.client.command.create.User(args);
    }
    
    void UpdateUserCmdCall(String[] args){
        new lib.client.command.update.User(args);
    }
    
    void DeleteUserCmdCall(String[] args){
        new lib.client.command.delete.User(args);
    }
}

