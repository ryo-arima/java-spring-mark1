package lib.entity.response;

import java.util.ArrayList;

public class Role {
    private String message;
    private int code;
    private ArrayList<lib.entity.model.Role> roles;

    public Role() {
        this.roles = new ArrayList<>();
    }

    public Role(String message, int code, ArrayList<lib.entity.model.Role> roles) {
        this.message = message;
        this.code = code;
        this.roles = roles;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public ArrayList<lib.entity.model.Role> getRoles() {
        return roles;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setRoles(ArrayList<lib.entity.model.Role> roles) {
        this.roles = roles;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}