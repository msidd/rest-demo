package com.github.msidd.demo.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by msidd on 11/20/2015.
 */
public class JsonPasswordAuthenticator extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        UsernamePasswordAuthenticationToken authRequest = getLoginToken(request);
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }


    private UsernamePasswordAuthenticationToken getLoginToken(HttpServletRequest request) {
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        JsonUser user = null;
        UsernamePasswordAuthenticationToken loginRequest = null;
        try {
            String line = null;
            reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            ObjectMapper mapper = new ObjectMapper();
            user = mapper.readValue(sb.toString(), JsonUser.class);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


        return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());


    }
}
