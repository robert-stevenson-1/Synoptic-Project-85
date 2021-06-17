/**
 *
 * Class:TaskTest#
 * Author: Elie Harris#
 * Date Created 16/6/21
 *
 * Description: JUNIT 5 Tests
 *
 * Progress:All Basic Tests Passed
 * May need to include a method for rehashing the password
 * as if it is setPassword is used the password can be matched to a string value
 */
package WaterDistibution.Model.ModelTesting;
import WaterDistibution.Model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class UserTest {
    @Test
    void getFirstName() {
        User u = new User("Test1", "Password1",
                "User", "Name");
        assertEquals("User", u.getFirstName());
    }

    @Test
    void getLastName() {
        User u = new User("Test1", "Password1",
                "User", "Name");
        assertEquals("Name", u.getLastName());
    }

    @Test
    void getName() {
        User u = new User("Test1", "Password1",
                "User", "Name");
        assertEquals("User Name", u.getName());
    }
    @Test
    void setUsername() {
        User u = new User("Test1", "Password1",
                "User", "Name");
        assertEquals("Test1", u.getUsername());
        u.setUsername("testUsername");
        assertEquals("testUsername", u.getUsername());
    }

    @Test
    void setPassword() {
        User u = new User("Test1", "Password1",
                "User", "Name");
        u.setPassword("Pass1");
        assertEquals("Pass1", u.getPassword());
    }
}