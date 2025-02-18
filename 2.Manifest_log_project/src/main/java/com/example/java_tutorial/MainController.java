package com.example.java_tutorial;

import com.sap.cloud.security.xsuaa.token.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "")
public class MainController {

    @GetMapping(path = "")
    public ResponseEntity<String> readAll(@AuthenticationPrincipal Token token) {
        log.info("call readAll");
        if (!token.getAuthorities().contains(new SimpleGrantedAuthority("Display"))) {
            String debug = "current role list is: " + token.getAuthorities();
            log.debug(debug);
            throw new NotAuthorizedException("This operation requires \"Display\" scope");
        }

        log.info("everything is ok");
        return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
    }
}
