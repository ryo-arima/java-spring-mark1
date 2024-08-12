package lib.entity.response;

public class UserRespose {
    String message;
    String code; 
    User[] users;
}

class User {
    int id;
    String uuid;
    String createdAt;
    String updatedAt;
    String deletedAt;
}
