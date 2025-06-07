package com.ecommerce.ecommerce.Repositories;

import com.ecommerce.ecommerce.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    List<User> findByName(String name);
    Optional<User> findByUsername(String username);


    @Query("SELECT u FROM User u WHERE u.active = true")
    List<User> findAllActive();
    @Query("SELECT u FROM User u WHERE u.active = false")
    List<User> findAllInactive();
}