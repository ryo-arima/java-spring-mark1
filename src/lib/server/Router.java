package lib.server;

import lib.server.controller.*;
import lib.server.usecase.*;
import lib.server.repository.*;
import lib.config.Config;
import lib.entity.response.*;
import lib.entity.request.*;
import lib.middleware.Auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class Router {
    
    private final lib.server.controller.User userController;
    private final lib.server.controller.Group groupController;
    private final lib.server.controller.Member memberController;
    private final lib.server.controller.Role roleController;
    private final Auth auth;
    
    public Router(lib.server.controller.User userController, 
                  lib.server.controller.Group groupController,
                  lib.server.controller.Member memberController,
                  lib.server.controller.Role roleController,
                  Auth auth) {
        this.userController = userController;
        this.groupController = groupController;
        this.memberController = memberController;
        this.roleController = roleController;
        this.auth = auth;
    }
    
    @Bean
    public RouterFunction<ServerResponse> routes() {
        return RouterFunctions
            // ============ AUTHENTICATION ENDPOINTS ============
            // OpenStack Keystone-style API versioning and structure
            .nest(path("/v1/share/common/auth"), 
                RouterFunctions
                    .route(POST("/tokens"), this::login)                    // Issue token (login)
                    .andRoute(DELETE("/tokens"), this::logout)              // Revoke token (logout)
                    .andRoute(GET("/tokens/validate"), this::validateToken) // Validate token
                    .andRoute(POST("/tokens/refresh"), this::refreshToken)  // Refresh token
                    .andRoute(GET("/tokens/user"), this::getUserInfo)       // Get user info from token
            )
            
            // ============ PUBLIC API ============
            // No authentication required
            .andNest(path("/v1/public"), 
                RouterFunctions
                    .route(POST("/user"), this::createUserPublic)           // User registration
                    .andRoute(GET("/users"), this::getUsersPublic)          // Get users (public)
            )
            
            // ============ INTERNAL API ============ 
            // Authentication required (standard operations)
            .andNest(path("/v1/internal"), 
                RouterFunctions
                    .route(GET("/users"), this::getUsersInternal)           // Get users
                    .andRoute(GET("/users/count"), this::countUsersInternal) // Count users
                    .andRoute(POST("/user"), this::createUserInternal)      // Create user
                    .andRoute(PUT("/user/{id}"), this::updateUserInternal)  // Update user
                    .andRoute(DELETE("/user/{id}"), this::deleteUserInternal) // Delete user
            )
            
            // ============ PRIVATE API ============
            // Administrative operations (admin only)
            .andNest(path("/v1/private"), 
                RouterFunctions
                    // User endpoints
                    .route(GET("/users"), this::getUsersPrivate)            // Get users (admin)
                    .andRoute(GET("/users/count"), this::countUsersPrivate) // Count users (admin)
                    .andRoute(POST("/user"), this::createUserPrivate)       // Create user (admin)
                    .andRoute(PUT("/user/{id}"), this::updateUserPrivate)   // Update user (admin)
                    .andRoute(DELETE("/user/{id}"), this::deleteUserPrivate) // Delete user (admin)
                    
                    // Group endpoints
                    .andRoute(GET("/groups"), this::getGroupsPrivate)       // Get groups
                    .andRoute(GET("/groups/count"), this::countGroupsPrivate) // Count groups
                    .andRoute(POST("/group"), this::createGroupPrivate)     // Create group
                    .andRoute(PUT("/group/{id}"), this::updateGroupPrivate) // Update group
                    .andRoute(DELETE("/group/{id}"), this::deleteGroupPrivate) // Delete group
                    
                    // Member endpoints
                    .andRoute(GET("/members"), this::getMembersPrivate)     // Get members
                    .andRoute(GET("/members/count"), this::countMembersPrivate) // Count members
                    .andRoute(POST("/member"), this::createMemberPrivate)   // Create member
                    .andRoute(PUT("/member/{id}"), this::updateMemberPrivate) // Update member
                    .andRoute(DELETE("/member/{id}"), this::deleteMemberPrivate) // Delete member
                    
                    // Role endpoints
                    .andRoute(GET("/roles"), this::getRolesPrivate)         // Get roles
                    .andRoute(GET("/roles/count"), this::countRolesPrivate) // Count roles
                    .andRoute(POST("/role"), this::createRolePrivate)       // Create role
                    .andRoute(PUT("/role/{id}"), this::updateRolePrivate)   // Update role
                    .andRoute(DELETE("/role/{id}"), this::deleteRolePrivate) // Delete role
            );
    }
    
    // ============ AUTHENTICATION HANDLERS ============
    
    private Mono<ServerResponse> login(ServerRequest request) {
        return request.bodyToMono(lib.entity.request.User.class)
            .flatMap(userRequest -> {
                // TODO: Implement login logic
                lib.entity.response.User response = new lib.entity.response.User();
                response.setMessage("Login endpoint - TODO: implement");
                return ServerResponse.ok().bodyValue(response);
            });
    }
    
    private Mono<ServerResponse> logout(ServerRequest request) {
        // TODO: Implement logout logic
        lib.entity.response.User response = new lib.entity.response.User();
        response.setMessage("Logout endpoint - TODO: implement");
        return ServerResponse.ok().bodyValue(response);
    }
    
    private Mono<ServerResponse> validateToken(ServerRequest request) {
        // TODO: Implement token validation logic
        lib.entity.response.User response = new lib.entity.response.User();
        response.setMessage("Token validation endpoint - TODO: implement");
        return ServerResponse.ok().bodyValue(response);
    }
    
    private Mono<ServerResponse> refreshToken(ServerRequest request) {
        // TODO: Implement token refresh logic
        lib.entity.response.User response = new lib.entity.response.User();
        response.setMessage("Token refresh endpoint - TODO: implement");
        return ServerResponse.ok().bodyValue(response);
    }
    
    private Mono<ServerResponse> getUserInfo(ServerRequest request) {
        // TODO: Implement get user info logic
        lib.entity.response.User response = new lib.entity.response.User();
        response.setMessage("Get user info endpoint - TODO: implement");
        return ServerResponse.ok().bodyValue(response);
    }
    
    // ============ PUBLIC API HANDLERS ============
    
    private Mono<ServerResponse> createUserPublic(ServerRequest request) {
        return request.bodyToMono(lib.entity.request.User.class)
            .flatMap(userRequest -> {
                // TODO: Implement public user creation logic
                lib.entity.response.User response = new lib.entity.response.User();
                response.setMessage("Public user creation endpoint - TODO: implement");
                return ServerResponse.ok().bodyValue(response);
            });
    }
    
    private Mono<ServerResponse> getUsersPublic(ServerRequest request) {
        // TODO: Implement public get users logic
        lib.entity.response.User response = new lib.entity.response.User();
        response.setMessage("Public get users endpoint - TODO: implement");
        return ServerResponse.ok().bodyValue(response);
    }
    
    // ============ INTERNAL API HANDLERS ============
    
    private Mono<ServerResponse> getUsersInternal(ServerRequest request) {
        return auth.validateInternalAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    // TODO: Implement internal get users logic
                    lib.entity.response.User response = new lib.entity.response.User();
                    response.setMessage("Internal get users endpoint - TODO: implement");
                    return ServerResponse.ok().bodyValue(response);
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> countUsersInternal(ServerRequest request) {
        return auth.validateInternalAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    // TODO: Implement internal count users logic
                    lib.entity.response.User response = new lib.entity.response.User();
                    response.setMessage("Internal count users endpoint - TODO: implement");
                    return ServerResponse.ok().bodyValue(response);
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> createUserInternal(ServerRequest request) {
        return auth.validateInternalAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    return request.bodyToMono(lib.entity.request.User.class)
                        .flatMap(userRequest -> {
                            // TODO: Implement internal user creation logic
                            lib.entity.response.User response = new lib.entity.response.User();
                            response.setMessage("Internal user creation endpoint - TODO: implement");
                            return ServerResponse.ok().bodyValue(response);
                        });
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> updateUserInternal(ServerRequest request) {
        return auth.validateInternalAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    String userId = request.pathVariable("id");
                    return request.bodyToMono(lib.entity.request.User.class)
                        .flatMap(userRequest -> {
                            // TODO: Implement internal user update logic
                            lib.entity.response.User response = new lib.entity.response.User();
                            response.setMessage("Internal user update endpoint for ID: " + userId + " - TODO: implement");
                            return ServerResponse.ok().bodyValue(response);
                        });
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> deleteUserInternal(ServerRequest request) {
        return auth.validateInternalAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    String userId = request.pathVariable("id");
                    // TODO: Implement internal user deletion logic
                    lib.entity.response.User response = new lib.entity.response.User();
                    response.setMessage("Internal user deletion endpoint for ID: " + userId + " - TODO: implement");
                    return ServerResponse.ok().bodyValue(response);
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    // ============ PRIVATE API HANDLERS ============
    
    private Mono<ServerResponse> getUsersPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    lib.entity.response.User response = userController.GetUsers();
                    return ServerResponse.ok().bodyValue(response);
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> countUsersPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    // TODO: Implement private count users logic
                    lib.entity.response.User response = new lib.entity.response.User();
                    response.setMessage("Private count users endpoint - TODO: implement");
                    return ServerResponse.ok().bodyValue(response);
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> createUserPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    return request.bodyToMono(lib.entity.request.User.class)
                        .flatMap(userRequest -> {
                            // TODO: Implement private user creation logic
                            lib.entity.response.User response = new lib.entity.response.User();
                            response.setMessage("Private user creation endpoint - TODO: implement");
                            return ServerResponse.ok().bodyValue(response);
                        });
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> updateUserPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    String userId = request.pathVariable("id");
                    return request.bodyToMono(lib.entity.request.User.class)
                        .flatMap(userRequest -> {
                            // TODO: Implement private user update logic
                            lib.entity.response.User response = new lib.entity.response.User();
                            response.setMessage("Private user update endpoint for ID: " + userId + " - TODO: implement");
                            return ServerResponse.ok().bodyValue(response);
                        });
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> deleteUserPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    String userId = request.pathVariable("id");
                    // TODO: Implement private user deletion logic
                    lib.entity.response.User response = new lib.entity.response.User();
                    response.setMessage("Private user deletion endpoint for ID: " + userId + " - TODO: implement");
                    return ServerResponse.ok().bodyValue(response);
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    // ============ GROUP API HANDLERS ============
    
    private Mono<ServerResponse> getGroupsPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    lib.entity.response.Group response = groupController.GetGroups();
                    return ServerResponse.ok().bodyValue(response);
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> countGroupsPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    lib.entity.response.Group response = groupController.CountGroups();
                    return ServerResponse.ok().bodyValue(response);
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> createGroupPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    return request.bodyToMono(lib.entity.request.Group.class)
                        .flatMap(groupRequest -> {
                            lib.entity.response.Group response = groupController.CreateGroup(groupRequest);
                            return ServerResponse.ok().bodyValue(response);
                        });
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> updateGroupPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    String groupId = request.pathVariable("id");
                    return request.bodyToMono(lib.entity.request.Group.class)
                        .flatMap(groupRequest -> {
                            lib.entity.response.Group response = groupController.UpdateGroup(groupId, groupRequest);
                            return ServerResponse.ok().bodyValue(response);
                        });
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> deleteGroupPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    String groupId = request.pathVariable("id");
                    lib.entity.response.Group response = groupController.DeleteGroup(groupId);
                    return ServerResponse.ok().bodyValue(response);
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    // ============ MEMBER API HANDLERS ============
    
    private Mono<ServerResponse> getMembersPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    lib.entity.response.Member response = memberController.GetMembers();
                    return ServerResponse.ok().bodyValue(response);
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> countMembersPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    lib.entity.response.Member response = memberController.CountMembers();
                    return ServerResponse.ok().bodyValue(response);
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> createMemberPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    return request.bodyToMono(lib.entity.request.Member.class)
                        .flatMap(memberRequest -> {
                            lib.entity.response.Member response = memberController.CreateMember(memberRequest);
                            return ServerResponse.ok().bodyValue(response);
                        });
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> updateMemberPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    String memberId = request.pathVariable("id");
                    return request.bodyToMono(lib.entity.request.Member.class)
                        .flatMap(memberRequest -> {
                            lib.entity.response.Member response = memberController.UpdateMember(memberId, memberRequest);
                            return ServerResponse.ok().bodyValue(response);
                        });
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> deleteMemberPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    String memberId = request.pathVariable("id");
                    lib.entity.response.Member response = memberController.DeleteMember(memberId);
                    return ServerResponse.ok().bodyValue(response);
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    // ============ ROLE API HANDLERS ============
    
    private Mono<ServerResponse> getRolesPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    lib.entity.response.Role response = roleController.GetRoles();
                    return ServerResponse.ok().bodyValue(response);
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> countRolesPrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    lib.entity.response.Role response = roleController.CountRoles();
                    return ServerResponse.ok().bodyValue(response);
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> createRolePrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    return request.bodyToMono(lib.entity.request.Role.class)
                        .flatMap(roleRequest -> {
                            lib.entity.response.Role response = roleController.CreateRole(roleRequest);
                            return ServerResponse.ok().bodyValue(response);
                        });
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> updateRolePrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    String roleId = request.pathVariable("id");
                    return request.bodyToMono(lib.entity.request.Role.class)
                        .flatMap(roleRequest -> {
                            lib.entity.response.Role response = roleController.UpdateRole(roleId, roleRequest);
                            return ServerResponse.ok().bodyValue(response);
                        });
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
    
    private Mono<ServerResponse> deleteRolePrivate(ServerRequest request) {
        return auth.validatePrivateAuth(request)
            .flatMap(validated -> {
                if (validated) {
                    String roleId = request.pathVariable("id");
                    lib.entity.response.Role response = roleController.DeleteRole(roleId);
                    return ServerResponse.ok().bodyValue(response);
                } else {
                    return ServerResponse.status(401).bodyValue("Unauthorized");
                }
            });
    }
}