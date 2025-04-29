package com.ecommerce.ecommerce.Repositories;

import com.ecommerce.ecommerce.Entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    List<User> findByUserName(String name);

}