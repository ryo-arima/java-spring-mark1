package lib.config;

import com.moandjiezana.toml.Toml;
import java.io.File;

public class ApplicationConfig{
    public AppToml toml;
    public ApplicationConfig(String[] args) {
        this.NewAppToml(args);
    }
    void NewAppToml(String[] args) {
        // TOMLファイルのパスを指定
        File file = new File("etc/app.toml");

        // TOMLファイルを読み込む
        Toml toml = new Toml().read(file);

        //// データを取得
        //String server = toml.getString("database.server");
        //long port = toml.getLong("database.port");
        //String user = toml.getString("database.user");
        //String password = toml.getString("database.password");

        //String ownerName = toml.getString("owner.name");
        //String dob = toml.getString("owner.dob");

        //// 結果を出力
        //System.out.println("Server: " + server);
        //System.out.println("Port: " + port);
        //System.out.println("User: " + user);
        //System.out.println("Password: " + password);
        //System.out.println("Owner Name: " + ownerName);
        //System.out.println("DOB: " + dob);
    }
}

class AppToml {
    private String name;
    private int age;

    // ゲッターとセッター
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}