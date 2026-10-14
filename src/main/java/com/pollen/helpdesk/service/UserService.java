package com.pollen.helpdesk.service;
import com.pollen.helpdesk.dto.UserResponse;
import com.pollen.helpdesk.entity.User;
import java.util.List;


/* what can the Service do not "HOW"
*create Users()
*get allUsers()
*getUsersById()
*deleteUser()
*/



import com.pollen.helpdesk.dto.UserResponse;
import com.pollen.helpdesk.entity.User;

import java.util.List;

public interface UserService {

    UserResponse createUser(User user);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    void deleteUser(Long id);
}