package Workflow.example.Workflow.servicesTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.ERole;
import workflow.example.workflow.entity.Role;
import workflow.example.workflow.repository.RoleRepository;
import workflow.example.workflow.service.RoleService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @Test
    void createNewRole() {
        Role roleToCreate = new Role();
        Role createdRole = new Role();

        when(roleRepository.save(any(Role.class))).thenReturn(createdRole);

        Role result = roleService.createNewRole(roleToCreate);

        assertEquals(createdRole, result);
        verify(roleRepository, times(1)).save(roleToCreate);
    }
}
