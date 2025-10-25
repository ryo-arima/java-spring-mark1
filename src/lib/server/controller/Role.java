package lib.server.controller;

interface RoleControllerInterface {
    public lib.entity.response.Role GetRoles();
    public lib.entity.response.Role CountRoles();
    public lib.entity.response.Role CreateRole(lib.entity.request.Role roleRequest);
    public lib.entity.response.Role UpdateRole(String id, lib.entity.request.Role roleRequest);
    public lib.entity.response.Role DeleteRole(String id);
}

public class Role implements RoleControllerInterface{
    private final lib.server.usecase.Role roleUsecase;
    
    public Role(lib.server.usecase.Role roleUsecase) {
        this.roleUsecase = roleUsecase;
    }
   
    public lib.entity.response.Role GetRoles(){
        lib.entity.request.Role roleRequest = new lib.entity.request.Role();
        lib.entity.response.Role roleResponse = this.roleUsecase.GetRoles(roleRequest);
        return roleResponse;
    }

    public lib.entity.response.Role CountRoles(){
        lib.entity.request.Role roleRequest = new lib.entity.request.Role();
        lib.entity.response.Role roleResponse = new lib.entity.response.Role();
        roleResponse.setMessage("Count roles - TODO: implement in usecase");
        return roleResponse;
    }

    public lib.entity.response.Role CreateRole(lib.entity.request.Role roleRequest){
        lib.entity.response.Role roleResponse = new lib.entity.response.Role();
        roleResponse.setMessage("Create role - TODO: implement in usecase");
        return roleResponse;
    }

    public lib.entity.response.Role UpdateRole(String id, lib.entity.request.Role roleRequest){
        lib.entity.response.Role roleResponse = new lib.entity.response.Role();
        roleResponse.setMessage("Update role ID: " + id + " - TODO: implement in usecase");
        return roleResponse;
    }

    public lib.entity.response.Role DeleteRole(String id){
        lib.entity.response.Role roleResponse = new lib.entity.response.Role();
        roleResponse.setMessage("Delete role ID: " + id + " - TODO: implement in usecase");
        return roleResponse;
    }
}