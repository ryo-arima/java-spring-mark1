package lib.client.command;

import lib.config.ApplicationConfig;
import lib.client.command.ResourceCmd;


public class BaseCmd {
    BaseCmd(String[] args) {
        if (args.length > 0){
            String operationCmd = args[0];
            switch (operationCmd) {
                case "get":
                    new GetCmd(args);
                    break;
                case "create":
                    new CreateCmd(args);
                    break;
                case "update":
                    new UpdateCmd(args);
                    break;
                case "delete":
                    new DeleteCmd(args);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("get,create,update,delete...");
        }
    }
}

class GetCmd {
    GetCmd(String[] args) {
        if (args.length > 1){
            String targetResource = args[1];
            switch (targetResource) {
                case "users":
                    ResourceCmd resourceCmd = new ResourceCmd();
                    resourceCmd.GetUsersCmdCall(args);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("users");
        }
    }
}

class CreateCmd {
    CreateCmd(String[] args) {
        if (args.length > 1){
            String targetResource = args[1];
            switch (targetResource) {
                case "user":
                    ResourceCmd resourceCmd = new ResourceCmd();
                    resourceCmd.CreateUserCmdCall(args);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("user");
        }
    }
}   

class UpdateCmd {
    UpdateCmd(String[] args) {
        if (args.length > 1){
            String targetResource = args[1];
            switch (targetResource) {
                case "user":
                    ResourceCmd resourceCmd = new ResourceCmd();
                    resourceCmd.UpdateUserCmdCall(args);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("user");
        }
    }
}   

class DeleteCmd {
    DeleteCmd(String[] args) {
        if (args.length > 1){
            String targetResource = args[1];
            switch (targetResource) {
                case "user":
                    ResourceCmd resourceCmd = new ResourceCmd();
                    resourceCmd.DeleteUserCmdCall(args);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("user");
        }
    }
}