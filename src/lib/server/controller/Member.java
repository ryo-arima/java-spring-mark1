package lib.server.controller;

interface MemberControllerInterface {
    public lib.entity.response.Member GetMembers();
    public lib.entity.response.Member CountMembers();
    public lib.entity.response.Member CreateMember(lib.entity.request.Member memberRequest);
    public lib.entity.response.Member UpdateMember(String id, lib.entity.request.Member memberRequest);
    public lib.entity.response.Member DeleteMember(String id);
}

public class Member implements MemberControllerInterface{
    private final lib.server.usecase.Member memberUsecase;
    
    public Member(lib.server.usecase.Member memberUsecase) {
        this.memberUsecase = memberUsecase;
    }
   
    public lib.entity.response.Member GetMembers(){
        lib.entity.request.Member memberRequest = new lib.entity.request.Member();
        lib.entity.response.Member memberResponse = this.memberUsecase.GetMembers(memberRequest);
        return memberResponse;
    }

    public lib.entity.response.Member CountMembers(){
        lib.entity.request.Member memberRequest = new lib.entity.request.Member();
        lib.entity.response.Member memberResponse = new lib.entity.response.Member();
        memberResponse.setMessage("Count members - TODO: implement in usecase");
        return memberResponse;
    }

    public lib.entity.response.Member CreateMember(lib.entity.request.Member memberRequest){
        lib.entity.response.Member memberResponse = new lib.entity.response.Member();
        memberResponse.setMessage("Create member - TODO: implement in usecase");
        return memberResponse;
    }

    public lib.entity.response.Member UpdateMember(String id, lib.entity.request.Member memberRequest){
        lib.entity.response.Member memberResponse = new lib.entity.response.Member();
        memberResponse.setMessage("Update member ID: " + id + " - TODO: implement in usecase");
        return memberResponse;
    }

    public lib.entity.response.Member DeleteMember(String id){
        lib.entity.response.Member memberResponse = new lib.entity.response.Member();
        memberResponse.setMessage("Delete member ID: " + id + " - TODO: implement in usecase");
        return memberResponse;
    }
}