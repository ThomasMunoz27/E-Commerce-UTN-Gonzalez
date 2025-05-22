package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.Adress;
import com.ecommerce.ecommerce.Entities.Size;
import com.ecommerce.ecommerce.Entities.User;
import com.ecommerce.ecommerce.Repositories.AdressRepository;
import com.ecommerce.ecommerce.Repositories.SizeRepository;
import com.ecommerce.ecommerce.Repositories.UserRepository;
import com.ecommerce.ecommerce.payload.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService<User>{
    @Autowired
    private UserRepository userRepository;



    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(JpaRepository<User, Long> baseRepository) {
        super(baseRepository);
    }

    public List<User> findByName(String userName){
        return userRepository.findByName(userName);
    }

    public void registerUser(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUser(request.getUser());
        user.setEmail(request.getEmail());
        user.setDni(request.getDni());

        // Relacionar con entidades si existen
        Adress adress = adressRepository.findById(request.getAdressId()).orElse(null);
        Size size = sizeRepository.findById(request.getSizeId()).orElse(null);

        user.setAdress(adress);

        userRepository.save(user);
    }

}
