package lib.entity.response;

import java.util.ArrayList;

public class User {
    private String message;
    private int code; 
    private ArrayList<lib.entity.model.User> users;

    public User() {
        this.users = new ArrayList<>();
    }

    public User(String message, int code, ArrayList<lib.entity.model.User> users) {
        this.message = message;
        this.code = code;
        this.users = users;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public ArrayList<lib.entity.model.User> getUsers() {
        return users;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setUsers(ArrayList<lib.entity.model.User> users) {
        this.users = users;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
