package lib.server.repository;

import java.util.ArrayList;

interface MemberRepositoryInterface {
    public ArrayList<lib.entity.model.Member> SelectMembers();
    public int CountMembers();
    public lib.entity.model.Member SelectMember(String id);
    public boolean InsertMember(lib.entity.model.Member member);
    public boolean UpdateMember(String id, lib.entity.model.Member member);
    public boolean DeleteMember(String id);
}

public class Member implements MemberRepositoryInterface{
    private final lib.config.Config applicationConfig;

    public Member(lib.config.Config applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    public ArrayList<lib.entity.model.Member> SelectMembers(){
        // TODO: Implement database query
        return new ArrayList<lib.entity.model.Member>();
    }

    public int CountMembers(){
        // TODO: Implement database count query
        return 0;
    }

    public lib.entity.model.Member SelectMember(String id){
        // TODO: Implement database select by ID
        return new lib.entity.model.Member();
    }

    public boolean InsertMember(lib.entity.model.Member member){
        // TODO: Implement database insert
        return true;
    }

    public boolean UpdateMember(String id, lib.entity.model.Member member){
        // TODO: Implement database update
        return true;
    }

    public boolean DeleteMember(String id){
        // TODO: Implement database delete
        return true;
    }
}