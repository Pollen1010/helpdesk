package com.pollen.helpdesk.service;
import com.pollen.helpdesk.entity.User;
import java.util.List;


/* what can the Service do not "HOW"
*create Users()
*get allUsers()
*getUsersById()
*deleteUser()
*/

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUser(Long id);
}
