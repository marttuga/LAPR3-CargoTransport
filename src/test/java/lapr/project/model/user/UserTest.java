package lapr.project.model.user;

import lapr.project.model.port.Port;
import lapr.project.model.users.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {


    @Test
    void getUsername() {
        User user= new User("ruipo", "123rui",509647,"ruipo@gmail.com");
        assertEquals("ruipo", user.getUsername());
    }

    @Test
    void getUsername2() {
        User user= new User("ruipo", "123rui",509647,"ruipo@gmail.com");
        assertNotEquals("ruipo1", user.getUsername());
    }

    @Test
    void setUsername() {
        User user= new User("ruip", "123rui",509647,"ruipo@gmail.com");
        user.setUsername("ruip");
        assertEquals("ruip", user.getUsername());
    }

    @Test
    void getPassword() {
        User user= new User("ruipo", "123rui",509647,"ruipo@gmail.com");
        assertEquals("123rui", user.getPassword());
    }

    @Test
    void getPassword2() {
        User user= new User("ruipo", "123rui",509647,"ruipo@gmail.com");
        assertNotEquals("123rui321", user.getPassword());
    }

    @Test
    void setPassword() {
        User user= new User("ruip", "123rui",509647,"ruipo@gmail.com");
        user.setPassword("po");
        assertEquals("po", user.getPassword());
    }

    @Test
    void getRole() {
        User user= new User("ruipo", "123rui",509647,"manager");
        assertEquals("manager", user.getRole());

    }

    @Test
    void getRole2() {
        User user= new User("ruipo", "123rui",509647,"manager");
        assertNotEquals("collaborator", user.getRole());

    }

    @Test
    void setRole() {
        User user= new User("ruip", "123rui",509647,"manager");
        user.setRole("captain");
        assertEquals("captain", user.getRole());
    }

    @Test
    void getStaffID() {
        User user= new User("ruipo", "123rui",509647,"manager");
        assertEquals(509647, user.getStaffID());

    }

    @Test
    void getStaffID2() {
        User user= new User("ruipo", "123rui",509647,"manager");
        assertNotEquals(213456, user.getStaffID());

    }

    @Test
    void setStaffID() {
        User user= new User("ruip", "123rui",509647,"manager");
        user.setStaffID(123456);
        assertEquals(123456, user.getStaffID());
    }

    @Test
    void testEquals() {
        User user= new User("ruip", "123rui",509647,"manager");
        User user1= new User("ruip", "123rui",509647,"manager");
        assertEquals(user,user1);
    }

    @Test
    void testEquals2() {
        User user= null;
        User user1= null;
        assertEquals(user,user1);
    }

    @Test
    void testEquals3() {
        User user= new User("ruip", "123rui",509647,"manager");
        User user1= null;
        assertNotEquals(user,user1);
    }

    @Test
    void testHashCode() {
        User user= new User("ruip", "123rui",509647,"manager");
        assertEquals(595963241,user.hashCode());
    }

    @Test
    void testHashCodeNull() {
        User user= new User("ruip", "123rui",509647,"manager");
        assertNotEquals(0,user.hashCode());
    }
}