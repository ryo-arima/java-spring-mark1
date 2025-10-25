package lib.server.usecase;

import java.util.ArrayList;

interface RoleUsecaseInterface {
    public lib.entity.response.Role GetRoles(lib.entity.request.Role roleRequest);
    public lib.entity.response.Role CountRoles(lib.entity.request.Role roleRequest);
    public lib.entity.response.Role CreateRole(lib.entity.request.Role roleRequest);
    public lib.entity.response.Role UpdateRole(String id, lib.entity.request.Role roleRequest);
    public lib.entity.response.Role DeleteRole(String id, lib.entity.request.Role roleRequest);
}

public class Role implements RoleUsecaseInterface{
    private final lib.server.repository.Role roleRepository;
    private final lib.config.Config applicationConfig;
    
    public Role(lib.server.repository.Role roleRepository, lib.config.Config applicationConfig) {
        this.roleRepository = roleRepository;
        this.applicationConfig = applicationConfig;
    }

    public lib.entity.response.Role GetRoles(lib.entity.request.Role roleRequest){
        ArrayList<lib.entity.model.Role> roles = this.roleRepository.SelectRoles();
        lib.entity.response.Role roleResponse = new lib.entity.response.Role();
        roleResponse.setMessage("Roles retrieved successfully");
        roleResponse.setCode(200);
        roleResponse.setRoles(roles);
        return roleResponse;
    }

    public lib.entity.response.Role CountRoles(lib.entity.request.Role roleRequest){
        int count = this.roleRepository.CountRoles();
        lib.entity.response.Role roleResponse = new lib.entity.response.Role();
        roleResponse.setMessage("Roles count: " + count);
        roleResponse.setCode(200);
        return roleResponse;
    }

    public lib.entity.response.Role CreateRole(lib.entity.request.Role roleRequest){
        // TODO: Convert request to model and validate
        lib.entity.model.Role role = new lib.entity.model.Role();
        boolean success = this.roleRepository.InsertRole(role);
        
        lib.entity.response.Role roleResponse = new lib.entity.response.Role();
        if (success) {
            roleResponse.setMessage("Role created successfully");
            roleResponse.setCode(201);
        } else {
            roleResponse.setMessage("Failed to create role");
            roleResponse.setCode(500);
        }
        return roleResponse;
    }

    public lib.entity.response.Role UpdateRole(String id, lib.entity.request.Role roleRequest){
        lib.entity.model.Role role = new lib.entity.model.Role();
        boolean success = this.roleRepository.UpdateRole(id, role);
        
        lib.entity.response.Role roleResponse = new lib.entity.response.Role();
        if (success) {
            roleResponse.setMessage("Role updated successfully");
            roleResponse.setCode(200);
        } else {
            roleResponse.setMessage("Failed to update role");
            roleResponse.setCode(500);
        }
        return roleResponse;
    }

    public lib.entity.response.Role DeleteRole(String id, lib.entity.request.Role roleRequest){
        boolean success = this.roleRepository.DeleteRole(id);
        
        lib.entity.response.Role roleResponse = new lib.entity.response.Role();
        if (success) {
            roleResponse.setMessage("Role deleted successfully");
            roleResponse.setCode(200);
        } else {
            roleResponse.setMessage("Failed to delete role");
            roleResponse.setCode(500);
        }
        return roleResponse;
    }
}