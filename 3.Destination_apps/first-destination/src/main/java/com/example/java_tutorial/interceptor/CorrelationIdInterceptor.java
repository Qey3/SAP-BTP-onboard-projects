package com.example.java_tutorial.interceptor;


import com.example.java_tutorial.filter.CorrelationIdFilter;
import com.sap.hcp.cf.logging.common.LogContext;
import java.io.IOException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class CorrelationIdInterceptor implements ClientHttpRequestInterceptor {

  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] body,
      ClientHttpRequestExecution execution) throws IOException {
    String correlationId = LogContext.getCorrelationId();

    if (correlationId != null) {
      request.getHeaders().add(CorrelationIdFilter.CORRELATION_ID_HEADER, correlationId);
    }

    return execution.execute(request, body);
  }

}
