package lib.client.command;

import lib.config.Config;

public class App {
    public static void Execute(String[] args){
        Config appConf = new Config(args);
		App appCmd = new App(args);
    }
	
    public App(String[] args) {
        // Constructor implementation
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

