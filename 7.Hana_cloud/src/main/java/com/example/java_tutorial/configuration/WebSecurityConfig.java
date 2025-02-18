package com.example.java_tutorial.configuration;

import org.springframework.context.annotation.Configuration;


@Configuration
public class WebSecurityConfig {

    //@Autowired
    //XsuaaServiceConfiguration xsuaaServiceConfiguration;
    //
    //@SuppressWarnings({ "removal", "deprecation" })
    //@Bean
    //public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //
    //    http
    //            .sessionManagement()
    //            // session is created by approuter
    //            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    //            .and()
    //            // demand specific scopes depending on intended request
    //            .authorizeRequests()
    //
    //            .requestMatchers("/**").authenticated()
    //            .anyRequest().denyAll() // deny anything not configured above
    //            .and()
    //            .oauth2ResourceServer().jwt()
    //            .jwtAuthenticationConverter(getJwtAuthoritiesConverter());
    //
    //    return http.build();
    //}
    //
    ///**
    // * Customizes how GrantedAuthority are derived from a Jwt
    // *
    // * @returns jwt converter
    // */
    //Converter<Jwt, AbstractAuthenticationToken> getJwtAuthoritiesConverter() {
    //    TokenAuthenticationConverter converter = new TokenAuthenticationConverter(xsuaaServiceConfiguration);
    //    converter.setLocalScopeAsAuthorities(true);
    //    return converter;
    //}

}
