package com.example.java_tutorial.filter;

import com.sap.hcp.cf.logging.common.LogContext;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class CorrelationIdFilter implements Filter {

  public static final String CORRELATION_ID_HEADER = "x-correlationid";

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    String correlationId = httpRequest.getHeader(CORRELATION_ID_HEADER);

    // Store in LogContext for logging context
    LogContext.initializeContext(correlationId);
    // Optionally, you can add it to the response too:
    // ((HttpServletResponse) response).setHeader(CORRELATION_ID_HEADER, correlationId);

    try {
      chain.doFilter(request, response);
    } finally {
      MDC.remove(CORRELATION_ID_HEADER);
    }
  }

}
