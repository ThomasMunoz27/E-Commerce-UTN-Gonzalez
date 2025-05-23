package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.User;
import com.ecommerce.ecommerce.Services.BaseService;
import com.ecommerce.ecommerce.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
}
