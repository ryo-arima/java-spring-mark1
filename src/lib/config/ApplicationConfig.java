package lib.config;

import com.moandjiezana.toml.Toml;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.crypto.Data;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ApplicationConfig{
    public AppToml appToml;
    public TemplateEngine appClientTemplateEngine;
    public Connection dbConnection;

    public ApplicationConfig(String[] args) {
        this.NewAppToml(args);
        try {
            this.NewConnection(this.appToml.database);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.NewAppClientTemplate(args);
    }
    void NewAppToml(String[] args) {
        File file = new File("etc/app.toml");

        Toml toml = new Toml().read(file);

        this.appToml = new AppToml();
        this.appToml.database = new Database(
            toml.getString("database.host"),
            toml.getLong("database.port"),
            toml.getString("database.user"),
            toml.getString("database.pass"),
            toml.getString("database.db")
        );

        System.out.println(this.appToml.database.host);
        System.out.println(this.appToml.database.port);
        System.out.println(this.appToml.database.user);
        System.out.println(this.appToml.database.pass);
        System.out.println(this.appToml.database.db);
    }
    void NewAppClientTemplate(String[] args) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode("TEXT");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setPrefix("template/");
        templateResolver.setSuffix(".template");

        this.appClientTemplateEngine = new TemplateEngine();
        this.appClientTemplateEngine.setTemplateResolver(templateResolver);
    }
    void NewConnection(Database database) throws SQLException {
        String URL = "jdbc:mysql://" + database.host + ":" + database.port + "/" + database.db;
        String USER = database.user;
        String PASSWORD = database.pass;
        this.dbConnection = DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

class AppToml {
   Database database; 
}

class Database {
    final String host;
    final long port;
    final String user;
    final String pass;
    final String db;

    Database(String host, long port, String user, String pass, String db) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.db = db;
    }
}