package lib.entity.response;

import java.util.ArrayList;

public class Group {
    private String message;
    private int code;
    private ArrayList<lib.entity.model.Group> groups;

    public Group() {
        this.groups = new ArrayList<>();
    }

    public Group(String message, int code, ArrayList<lib.entity.model.Group> groups) {
        this.message = message;
        this.code = code;
        this.groups = groups;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public ArrayList<lib.entity.model.Group> getGroups() {
        return groups;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setGroups(ArrayList<lib.entity.model.Group> groups) {
        this.groups = groups;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}