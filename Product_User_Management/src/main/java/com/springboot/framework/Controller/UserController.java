package com.springboot.framework.Controller;

import com.springboot.framework.Entity.Order;
import com.springboot.framework.Entity.User;
import com.springboot.framework.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  public static final Logger  logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

@GetMapping("/{id}")
    public User getUserById(@PathVariable ("id") Integer user_id){
        return userService.getUserById(user_id);
}

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable ("id") Integer user_id,@RequestBody User user){
        User updatedUser = userService.updateUser(user_id,user);
        logger.info(" Updated User Record {} ", updatedUser);
        return updatedUser;
    }

    @DeleteMapping("/{id}")
    public void deleteByUserId(@PathVariable ("id") Integer user_id){
         userService.deleteByUserId(user_id);

    }



}
