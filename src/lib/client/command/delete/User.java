package lib.client.command.delete;

import lib.config.Config;
import org.apache.commons.cli.*;

public class User {
    public User(String[] args){
        Config applicationConfig = new Config(args);
        lib.client.repository.User userRepository = new lib.client.repository.User(applicationConfig);
        lib.client.usecase.User userUsecase = new lib.client.usecase.User(userRepository);
        lib.client.controller.User userController = new lib.client.controller.User(userUsecase);
        userController.DeleteUser();
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