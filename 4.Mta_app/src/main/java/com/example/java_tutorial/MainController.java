package com.example.java_tutorial;

import com.sap.cloud.security.xsuaa.token.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MainController {

    @GetMapping(path = "/")
    public ResponseEntity<String> readAll(@AuthenticationPrincipal Token token) {
        if (!token.getAuthorities().contains(new SimpleGrantedAuthority("Display"))) {
            throw new NotAuthorizedException("This operation requires \"Display\" scope");
        }

        return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
    }
}
