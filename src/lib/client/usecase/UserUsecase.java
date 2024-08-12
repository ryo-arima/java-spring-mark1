package lib.client.usecase;

import lib.client.repository.UserRepository;
import lib.entity.request.UserRequest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

interface UserUsecaseInterface {
    public void GetUsers();
    public void CreateUser();
    public void UpdateUser();
    public void DeleteUser();
}

public class UserUsecase implements UserUsecaseInterface{
    private UserRepository userRepository;
    
    public void GetUsers(){
        UserRequest userRequest = new UserRequest();
        this.userRepository.GetUsers(userRequest);
        // テンプレートリゾルバの設定
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode("TEXT");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setPrefix("template/");
        templateResolver.setSuffix(".template");

        // テンプレートエンジンの設定
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        // コンテキストにデータをセット
        Context context = new Context();
        context.setVariable("name", "Thymeleaf");

        // テンプレートを処理
        String output = templateEngine.process("get_users", context);

        // 結果を出力
        System.out.println(output);
    }

    public void CreateUser(){
        UserRequest userRequest = new UserRequest();
        this.userRepository.CreateUser(userRequest);
    }

    public void UpdateUser(){
        UserRequest userRequest = new UserRequest();
        this.userRepository.UpdateUser(userRequest);
    }

    public void DeleteUser(){
        UserRequest userRequest = new UserRequest();
        this.userRepository.DeleteUser(userRequest);
    }

    public UserUsecase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
