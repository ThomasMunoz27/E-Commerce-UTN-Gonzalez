package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.User;
import com.ecommerce.ecommerce.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService<User>{
    @Autowired
    private UserRepository userRepository;


    public UserService(JpaRepository<User, Long> baseRepository) {
        super(baseRepository);
    }
}
