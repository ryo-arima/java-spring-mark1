package lib.entity.response;

import java.util.ArrayList;
import lib.entity.model.User;

public class UserResponse {
    private String message;
    private String code; 
    private ArrayList<User> users;

    public UserResponse(String message, String code, ArrayList<User> users) {
        this.message = message;
        this.code = code;
        this.users = users;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
