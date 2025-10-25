package lib.server.usecase;

import java.util.ArrayList;

interface MemberUsecaseInterface {
    public lib.entity.response.Member GetMembers(lib.entity.request.Member memberRequest);
    public lib.entity.response.Member CountMembers(lib.entity.request.Member memberRequest);
    public lib.entity.response.Member CreateMember(lib.entity.request.Member memberRequest);
    public lib.entity.response.Member UpdateMember(String id, lib.entity.request.Member memberRequest);
    public lib.entity.response.Member DeleteMember(String id, lib.entity.request.Member memberRequest);
}

public class Member implements MemberUsecaseInterface{
    private final lib.server.repository.Member memberRepository;
    private final lib.config.Config applicationConfig;
    
    public Member(lib.server.repository.Member memberRepository, lib.config.Config applicationConfig) {
        this.memberRepository = memberRepository;
        this.applicationConfig = applicationConfig;
    }

    public lib.entity.response.Member GetMembers(lib.entity.request.Member memberRequest){
        ArrayList<lib.entity.model.Member> members = this.memberRepository.SelectMembers();
        lib.entity.response.Member memberResponse = new lib.entity.response.Member();
        memberResponse.setMessage("Members retrieved successfully");
        memberResponse.setCode(200);
        memberResponse.setMembers(members);
        return memberResponse;
    }

    public lib.entity.response.Member CountMembers(lib.entity.request.Member memberRequest){
        int count = this.memberRepository.CountMembers();
        lib.entity.response.Member memberResponse = new lib.entity.response.Member();
        memberResponse.setMessage("Members count: " + count);
        memberResponse.setCode(200);
        return memberResponse;
    }

    public lib.entity.response.Member CreateMember(lib.entity.request.Member memberRequest){
        // TODO: Convert request to model and validate
        lib.entity.model.Member member = new lib.entity.model.Member();
        boolean success = this.memberRepository.InsertMember(member);
        
        lib.entity.response.Member memberResponse = new lib.entity.response.Member();
        if (success) {
            memberResponse.setMessage("Member created successfully");
            memberResponse.setCode(201);
        } else {
            memberResponse.setMessage("Failed to create member");
            memberResponse.setCode(500);
        }
        return memberResponse;
    }

    public lib.entity.response.Member UpdateMember(String id, lib.entity.request.Member memberRequest){
        lib.entity.model.Member member = new lib.entity.model.Member();
        boolean success = this.memberRepository.UpdateMember(id, member);
        
        lib.entity.response.Member memberResponse = new lib.entity.response.Member();
        if (success) {
            memberResponse.setMessage("Member updated successfully");
            memberResponse.setCode(200);
        } else {
            memberResponse.setMessage("Failed to update member");
            memberResponse.setCode(500);
        }
        return memberResponse;
    }

    public lib.entity.response.Member DeleteMember(String id, lib.entity.request.Member memberRequest){
        boolean success = this.memberRepository.DeleteMember(id);
        
        lib.entity.response.Member memberResponse = new lib.entity.response.Member();
        if (success) {
            memberResponse.setMessage("Member deleted successfully");
            memberResponse.setCode(200);
        } else {
            memberResponse.setMessage("Failed to delete member");
            memberResponse.setCode(500);
        }
        return memberResponse;
    }
}