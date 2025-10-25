package lib.client.command;

// Using fully qualified names to avoid conflicts

class BootstrapCmd {
    BootstrapCmd(String[] args) {
        if (args.length > 1){
            String targetResource = args[1];
            switch (targetResource) {
                case "user":
                    lib.client.command.Resource resourceCmd = new lib.client.command.Resource();
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
                    lib.client.command.Resource resourceCmd = new lib.client.command.Resource();
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
                    lib.client.command.Resource resourceCmd = new lib.client.command.Resource();
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
                    lib.client.command.Resource resourceCmd = new lib.client.command.Resource();
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
                    lib.client.command.Resource resourceCmd = new lib.client.command.Resource();
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