package com.example.java_tutorial;

import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpClientAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestination;
import com.sap.cloud.security.xsuaa.token.Token;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping(path = "")
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @GetMapping(path = "")
    public ResponseEntity<String> readAll(@AuthenticationPrincipal Token token) throws IOException {
        if (!token.getAuthorities().contains(new SimpleGrantedAuthority("Display"))) {
            throw new NotAuthorizedException("This operation requires \"Display\" scope");
        }

        String responseString = "";

        try {
            HttpDestination destination = DestinationAccessor.getLoader().tryGetDestination("noauth_destination")
                    .get().asHttp();

            HttpClient client = HttpClientAccessor.getHttpClient(destination);
            HttpGet httpGet = new HttpGet(destination.getUri() + "/hello");

            HttpResponse httpResponse = client.execute(httpGet);
            responseString = IOUtils.toString(httpResponse.getEntity().getContent(), StandardCharsets.UTF_8);

        } catch (IOException e) {
            log.warn("there was error: " + e.getMessage());
        }

        return new ResponseEntity<>("Hello World! Response from destination: " + responseString, HttpStatus.OK);
    }
}
