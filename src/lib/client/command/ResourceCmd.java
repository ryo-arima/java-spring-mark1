package lib.client.command;

import lib.client.command.get.GetUsersCmd;
import lib.client.command.create.CreateUserCmd;
import lib.client.command.update.UpdateUserCmd;
import lib.client.command.delete.DeleteUserCmd;
import lib.client.command.bootstrap.BootstrapUserCmd;

public class ResourceCmd{
    ResourceCmd() {}
    void BootstrapUserCmdCall(String[] args){
        BootstrapUserCmd BootstrapUserCmd = new BootstrapUserCmd(args);
    }
    void GetUsersCmdCall(String[] args){
        GetUsersCmd getUsersCmd = new GetUsersCmd(args);
    }
    void CreateUserCmdCall(String[] args){
        CreateUserCmd createUserCmd = new CreateUserCmd(args);
    }
    void UpdateUserCmdCall(String[] args){
        UpdateUserCmd updateUserCmd = new UpdateUserCmd(args);
    }
    void DeleteUserCmdCall(String[] args){
        DeleteUserCmd deleteUserCmd = new DeleteUserCmd(args);
    }
}

