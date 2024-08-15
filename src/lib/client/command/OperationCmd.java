package lib.client.command;

import lib.client.command.get.GetUsersCmd;
import lib.client.command.create.CreateUserCmd;
import lib.client.command.update.UpdateUserCmd;
import lib.client.command.delete.DeleteUserCmd;
import lib.client.command.bootstrap.BootstrapUserCmd;

class BootstrapCmd {
    BootstrapCmd(String[] args) {
        if (args.length > 1){
            String targetResource = args[1];
            switch (targetResource) {
                case "user":
                    ResourceCmd resourceCmd = new ResourceCmd();
                    resourceCmd.BootstrapUserCmdCall(args);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("user");
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