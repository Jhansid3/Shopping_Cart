package com.springboot.framework.Service;

import com.springboot.framework.Entity.AddressPk;
import com.springboot.framework.Entity.User;
import com.springboot.framework.Repository.AddressRepository;
import com.springboot.framework.Repository.OrderRepository;
import com.springboot.framework.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

public static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OrderRepository orderRepository;



    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int user_id){
        Optional<User> userOptional = userRepository.findById(user_id);
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        else
            return null;
    }

    public User createUser(User user){
        logger.info("user deatils  {}", user);
        return userRepository.save(user);
    }

    public User updateUser(int user_id,User user){
        Optional<User> optionalUpdateUser = userRepository.findById(user_id);
        if(optionalUpdateUser.isPresent()){
            User userDetails =optionalUpdateUser.get();
            userDetails.setFirstname(user.getFirstname());
            userDetails.setLastname(user.getLastname());
            userDetails.setPassword(user.getPassword());
            userDetails.setEmail(user.getEmail());
            userDetails.setMobile(user.getMobile());
            userDetails.setAddresses(user.getAddresses());
            return userRepository.save(userDetails);
        }
        else {
            logger.warn("User is not found");
            return null;
        }
    }

    public void deleteByUserId(Integer user_id) {
        logger.info(" user id {}" ,user_id);
        addressRepository.deleteByAddressPk_UserId(user_id);
        orderRepository.deleteByUserId(user_id);
        userRepository.deleteById(user_id);
        logger.info("User is found .User record is deleted successfully !!");
    }


}
