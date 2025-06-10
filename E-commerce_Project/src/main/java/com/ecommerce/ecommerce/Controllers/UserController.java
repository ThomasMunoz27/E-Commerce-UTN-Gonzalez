package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.User;
import com.ecommerce.ecommerce.Services.BaseService;
import com.ecommerce.ecommerce.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController extends BaseController<User>{
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        super(userService); this.userService = userService;
    }

    @GetMapping("/search")
    public Optional<User> searchByName(@RequestParam String userName){
        return userService.findByName(userName);
    }


    public ResponseEntity<List<User>> getAllActive() throws Exception{
        return ResponseEntity.ok(userService.findAllActive());
    }

    @GetMapping("/active")
    public ResponseEntity<List<User>> getAllActives() throws Exception{
        return ResponseEntity.ok(userService.findAllActive());
    }
    @GetMapping("/inactive")
    public ResponseEntity<List<User>> getAllInactive() throws Exception{
        return ResponseEntity.ok(userService.findAllInactive());
    }
}
