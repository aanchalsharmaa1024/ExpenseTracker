package com.example.expense.service;

import com.example.expense.entity.Users;
import com.example.expense.repository.UsersRepo;
import com.example.expense.requests.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UsersRepo usersRepo;

    public Users addUser(Users user) {

         return usersRepo.save(user);

    }

    public Boolean loginUser(LoginRequest loginRequest) {

        Optional<Users> user = usersRepo.findById(loginRequest.getUserId());

        if (user.isEmpty()) {
            return false;
        }

        Users user1 = user.get();

        return user1.getPassword().equals(loginRequest.getPassword());

    }
}
