package lib.client.command;

import lib.config.Config;

public class Anonymous {
    public static void Execute(String[] args){
        Config appConf = new Config(args);
		Anonymous anonymousCmd = new Anonymous(args);
    }
	
    public Anonymous(String[] args) {
        // Constructor implementation
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