package Workflow.example.Workflow.servicesTests;

import org.junit.jupiter.api.Test;
import workflow.example.workflow.service.UserDetailsImpl;
import static org.junit.jupiter.api.Assertions.*;

class UserDetailsImplTest {

    @Test
    void userDetailsEquality() {
        UserDetailsImpl user1 = new UserDetailsImpl(1L, "testUser", "test@example.com", "password", null);
        UserDetailsImpl user2 = new UserDetailsImpl(1L, "testUser", "test@example.com", "password", null);
        UserDetailsImpl user3 = new UserDetailsImpl(2L, "anotherUser", "another@example.com", "password", null);

        assertEquals(user1, user2);
        assertNotEquals(user1, user3);
    }
}