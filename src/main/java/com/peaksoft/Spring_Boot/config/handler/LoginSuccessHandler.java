package com.peaksoft.Spring_Boot.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException {
//        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
//        if (roles.contains("ROLE_ADMIN")) {
//            httpServletResponse.sendRedirect("/admin");
//        } else {
//            httpServletResponse.sendRedirect("/user");
//        }

        httpServletResponse.sendRedirect(getRedirectUrl(authentication));
    }

    public String getRedirectUrl(Authentication auth) {
        Set<String> authorities = auth
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
        if (authorities.contains("ROLE_ADMIN")) return "/admin";
        if (authorities.contains("ROLE_USER")) return "/user";
        return "/login";
    }
}
