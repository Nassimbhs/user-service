package workflow.example.workflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import workflow.example.workflow.entity.Role;
import workflow.example.workflow.service.RoleService;

@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/createNewRole")
    public Role createNewRole(Role role){
        return roleService.createNewRole(role);
    }

}
