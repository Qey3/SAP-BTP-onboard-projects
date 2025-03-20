package com.example.java_tutorial;

import com.example.java_tutorial.filter.CorrelationIdFilter;
import com.sap.cloud.sdk.cloudplatform.connectivity.DefaultHttpDestination;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpClientAccessor;
import com.sap.cloud.security.xsuaa.token.Token;
import com.sap.hcp.cf.logging.common.LogContext;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "")
public class MainController {

  private static final Logger log = LoggerFactory.getLogger(MainController.class);
  private static final String DESTINATION_NAME = "password_destination";

  @GetMapping(path = "")
  public ResponseEntity<String> readAll(@AuthenticationPrincipal Token token) throws IOException {
    if (!token.getAuthorities().contains(new SimpleGrantedAuthority("Display"))) {
      throw new NotAuthorizedException("This operation requires \"Display\" scope");
    }

    String responseString = callExternalService();
    log.info("password destination responseString: {}", responseString);
    return new ResponseEntity<>("Hello World! Response from destination: " + responseString,
        HttpStatus.OK);
  }


  public String callExternalService() {
    try {
      DefaultHttpDestination httpDestination = DefaultHttpDestination.fromDestination(
              DestinationAccessor.getDestination(DESTINATION_NAME))
          .header(CorrelationIdFilter.CORRELATION_ID_HEADER, LogContext.getCorrelationId())
          .build();

      HttpClient httpClient = HttpClientAccessor.getHttpClient(httpDestination);
      HttpGet request = new HttpGet("/hello"); // relative path only

      log.info("call password destination");
      HttpResponse response = httpClient.execute(request);
      return EntityUtils.toString(response.getEntity());

    } catch (Exception e) {
      log.error(e.getMessage());
      return "";
    }
  }

}
