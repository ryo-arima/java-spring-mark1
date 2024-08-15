package lib.entity.request;

public class UserRequest {
    public User user;
}

class User {
    public int id;
    public String uuid;
    public String createdAt;
    public String updatedAt;
    public String deletedAt;
}