package lib.entity.response;

import java.util.ArrayList;

public class Member {
    private String message;
    private int code;
    private ArrayList<lib.entity.model.Member> members;

    public Member() {
        this.members = new ArrayList<>();
    }

    public Member(String message, int code, ArrayList<lib.entity.model.Member> members) {
        this.message = message;
        this.code = code;
        this.members = members;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public ArrayList<lib.entity.model.Member> getMembers() {
        return members;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMembers(ArrayList<lib.entity.model.Member> members) {
        this.members = members;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}