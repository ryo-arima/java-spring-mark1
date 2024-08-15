package lib.client.command;

import lib.config.ApplicationConfig;

public class AnonymousCmd {
    public static void Execute(String[] args){
        ApplicationConfig appConf = new ApplicationConfig(args);
		AnonymousCmd anonymousCmd = new AnonymousCmd(args);
    }
	
    AnonymousCmd(String[] args) {
        AnonymousBaseCmd AnonymousBaseCmd = new AnonymousBaseCmd(args);
    }
}

class AnonymousBaseCmd {
    AnonymousBaseCmd(String[] args) {
        if (args.length > 0){
            String operationCmd = args[0];
            switch (operationCmd) {
                case "get":
                    new GetCmd(args);
                    break;
                case "create":
                    new CreateCmd(args);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("get,create");
        }
    }
}