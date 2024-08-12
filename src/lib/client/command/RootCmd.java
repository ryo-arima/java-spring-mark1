package lib.client.command;

import lib.client.command.BaseCmd;
import lib.config.ApplicationConfig;

public class RootCmd {
    public static void Execute(String[] args){
        ApplicationConfig appConf = new ApplicationConfig(args);
		RootCmd rootCmd = new RootCmd(args);
    }
	
    RootCmd(String[] args) {
        BaseCmd baseCmd = new BaseCmd(args);
    }
}