package com.example.springsecurityjwt;

import com.example.springsecurityjwt.model.AuthenicationRequest;
import com.example.springsecurityjwt.model.AuthenicationResponse;
import com.example.springsecurityjwt.service.MyUserDetailService;
import com.example.springsecurityjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping({"/hello"})
    public String hello(){
        return "Hello JWT";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenicationRequest authenicationRequest) throws Exception{
        try{
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenicationRequest.getUsername(),
                authenicationRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw  new BadCredentialsException("Invalid Username and password",e);
        }
      final UserDetails userDetails =
              userDetailService.loadUserByUsername(authenicationRequest.getUsername());
        final String jwt= jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenicationResponse(jwt));
    }

}
