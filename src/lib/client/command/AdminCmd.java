package lib.client.command;

import lib.config.ApplicationConfig;

public class AdminCmd {
    public static void Execute(String[] args){
        ApplicationConfig appConf = new ApplicationConfig(args);
		AdminCmd adminCmd = new AdminCmd(args);
    }
	
    AdminCmd(String[] args) {
        AdminBaseCmd AdminBaseCmd = new AdminBaseCmd(args);
    }
}

class AdminBaseCmd {
    AdminBaseCmd(String[] args) {
        if (args.length > 0){
            String operationCmd = args[0];
            switch (operationCmd) {
                case "bootstrap":
                    new BootstrapCmd(args);
                    break;
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
