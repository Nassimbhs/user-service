package workflow.example.workflow.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import workflow.example.workflow.entity.Role;
import workflow.example.workflow.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role createNewRole(Role role){
        return roleRepository.save(role);
    }

}
