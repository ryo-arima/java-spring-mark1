package lib.client.command.bootstrap;

import lib.config.ApplicationConfig;
import lib.client.repository.UserRepository;
import lib.client.usecase.UserUsecase;
import lib.client.controller.UserController;
import org.apache.commons.cli.*;

public class BootstrapUserCmd{
    public BootstrapUserCmd(String[] args){
        ApplicationConfig applicationConfig = new ApplicationConfig(args);
        UserRepository userRepository = new UserRepository(applicationConfig);
        UserUsecase userUsecase = new UserUsecase(userRepository);
        UserController userController = new UserController(userUsecase);
        userController.CreateUser();
        Options options = new Options();

        // --help オプションを定義
        options.addOption("h", "help", false, "Show help");

        // --name オプションを定義
        options.addOption("n", "name", true, "Your name");

        // --age オプションを定義
        options.addOption("a", "age", true, "Your age");

        // コマンドライン引数を解析
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);

            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("Main", options);
                return;
            }

            String name = cmd.getOptionValue("n");
            String age = cmd.getOptionValue("a");

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);

        } catch (ParseException e) {
            System.out.println("Error parsing command line: " + e.getMessage());
        }
    }
}