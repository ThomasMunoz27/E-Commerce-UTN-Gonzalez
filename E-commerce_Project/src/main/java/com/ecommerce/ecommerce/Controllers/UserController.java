package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.User;
import com.ecommerce.ecommerce.Services.BaseService;

public class UserController extends BaseController<User>{
    public UserController(BaseService<User> baseService) {
        super(baseService);
    }
}
