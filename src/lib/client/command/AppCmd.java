package lib.client.command;

import lib.config.ApplicationConfig;

public class AppCmd {
    public static void Execute(String[] args){
        ApplicationConfig appConf = new ApplicationConfig(args);
		AppCmd appCmd = new AppCmd(args);
    }
	
    AppCmd(String[] args) {
        AppBaseCmd AppBaseCmd = new AppBaseCmd(args);
    }
}

class AppBaseCmd {
    AppBaseCmd(String[] args) {
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

