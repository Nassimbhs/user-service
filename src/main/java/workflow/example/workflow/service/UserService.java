package workflow.example.workflow.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import workflow.example.workflow.entity.Role;
import workflow.example.workflow.entity.User;
import workflow.example.workflow.repository.UserRepository;
import javax.transaction.Transactional;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ResponseEntity<Object> updateUser(Long id, User user) {
        userRepository.findById(id).ifPresentOrElse(
                a -> {
                    a.setUsername(user.getUsername());
                    a.setEmail(user.getEmail());
                    a.setPassword(passwordEncoder.encode(user.getPassword()));
                    userRepository.save(a);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found !");
                });
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("user", user);
        responseBody.put("message", "user successfully updated!");

        return ResponseEntity.ok().body(responseBody);

    }

    public User findUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Set<String> getRoleNamesByUserId(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            var user = optionalUser.get();
            Set<Role> roles = user.getRoles();
            Set<String> roleNames = new HashSet<>();
            for (Role role : roles) {
                roleNames.add(role.getName().toString());
            }
            return roleNames;
        } else {
            return Collections.emptySet();
        }
    }
    public List<User> getUsersByGroupId(Long groupId) {
        return userRepository.findByGroupId(groupId);
    }

    public List<User> getUsersByRoleUser() {
        return userRepository.findUsersByRoleUser();
    }

}