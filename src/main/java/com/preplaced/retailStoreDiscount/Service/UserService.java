package com.preplaced.retailStoreDiscount.Service;

import com.preplaced.retailStoreDiscount.pojo.ApiResponse;
import com.preplaced.retailStoreDiscount.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.preplaced.retailStoreDiscount.model.User;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public ApiResponse createUser(User user) {
        System.out.println("User" + user);
        userRepository.save(user);
        return new ApiResponse(HttpStatus.CREATED, "User Created Successfully!", null);
    }

    public ApiResponse getUserById(Long id) {
        System.out.println("User" + id);
        User user = userRepository.findById(id);
        System.out.println(user);
        return new ApiResponse(HttpStatus.CREATED, "User get Successfully!", user);
    }
}
