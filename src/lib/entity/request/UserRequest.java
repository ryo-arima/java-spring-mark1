package lib.entity.request;

public class UserRequest {
    User user;
}

class User {
    int id;
    String uuid;
    String createdAt;
    String updatedAt;
    String deletedAt;
}