package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.User;
import com.ecommerce.ecommerce.Services.BaseService;
import com.ecommerce.ecommerce.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController extends BaseController<User>{

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        super(userService);
    }

    @GetMapping("/search")
    public List<User> searchByName(@RequestParam String userName){
        return userService.findByName(userName);
    }



    @GetMapping("/active")
    public ResponseEntity<List<User>> getAllActives() throws Exception{
        return ResponseEntity.ok(userService.findAllActive());
    }

    @GetMapping("/inactive")
    public ResponseEntity<List<User>> getAllInactives() throws Exception{
        return ResponseEntity.ok(userService.findAllInactive());
    }
}
