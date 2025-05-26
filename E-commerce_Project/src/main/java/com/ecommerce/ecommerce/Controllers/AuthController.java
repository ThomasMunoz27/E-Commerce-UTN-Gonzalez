package com.ecommerce.ecommerce.Controllers;



import com.ecommerce.ecommerce.Services.UserService;
import com.ecommerce.ecommerce.jwt.JwtUtil;
import com.ecommerce.ecommerce.payload.AuthRequest;
import com.ecommerce.ecommerce.payload.AuthResponse;
import com.ecommerce.ecommerce.Services.CustomUserDetailsService;
import com.ecommerce.ecommerce.payload.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String token = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        userService.registerUser(request);
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }
}
