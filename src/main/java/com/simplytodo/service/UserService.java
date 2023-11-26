package com.simplytodo.service;

import com.simplytodo.dao.UserDAO;
import com.simplytodo.entity.User;
import com.simplytodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDAO userDAO;

    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    public User getUserByEmail(String email) {
         var o_user = userRepository.findByEmail(email);
         if(o_user.isPresent()) {
             return o_user.get();
         }
            return null;
    }

    public User createOrUpdateUser(User user) {
        var db_user = getUserByEmail(user.getEmail());
        if(db_user != null) {
            // user already exists, only update a few fields
            db_user.setName(user.getName());
            db_user.setPhone(user.getPhone());
            db_user.setPassword(user.getPassword());
            return userRepository.saveAndFlush(db_user);
        }
        // user does not exist, create a new user
        return userRepository.saveAndFlush(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public List<User> getUserByNameAndPhone(String name, String phone) {
        return null;//userRepository.getUserByNameAndPhoneSPEL(name, phone);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getAllUserWithTaskTitle(String taskTitle){
        return userDAO.getAllUserWithTaskTitle(taskTitle);
    }
}
