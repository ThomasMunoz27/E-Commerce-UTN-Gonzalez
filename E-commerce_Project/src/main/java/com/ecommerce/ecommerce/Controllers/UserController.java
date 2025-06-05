package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.User;
import com.ecommerce.ecommerce.Services.BaseService;
import com.ecommerce.ecommerce.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController extends BaseController<User>{

    private UserService userService;

    public UserController(UserService userService) {
        super(userService);
    }

    @GetMapping("/search")
    public List<User> searchByName(@RequestParam String userName){
        return userService.findByName(userName);
    }

    public ResponseEntity<List<User>> getAllActive() throws Exception{
        return ResponseEntity.ok(userService.findAllActive());
    }

    @GetMapping("/active")
    public ResponseEntity<List<User>> getAllActives() throws Exception{
        return ResponseEntity.ok(userService.findAllActive());
    }
}
