package com.mpedroni.jwtauthspringboot.web;

import com.mpedroni.jwtauthspringboot.security.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwt;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwt) {
        this.authenticationManager = authenticationManager;
        this.jwt = jwt;
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
            new UsernamePasswordAuthenticationToken(request.email(),
                request.password());

        Authentication authenticate = this.authenticationManager
            .authenticate(usernamePasswordAuthenticationToken);

        var user = (User) authenticate.getPrincipal();

        return jwt.generate(user.getUsername());
    }

    public record AuthRequest(String email, String password) {}
}
