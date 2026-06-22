package com.java.vintageBooks.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        HttpSession session = request.getSession(false);

        // If a valid session exists for ANY role, let the request pass through
        if (session != null && (session.getAttribute("buyerobject") != null 
                || session.getAttribute("sellerobject") != null 
                || session.getAttribute("adminobject") != null)) {
            return true;
        }

        // Otherwise, they don't have a session. Kick them back to landing page.
        response.sendRedirect("/?sessionExpired=true");
        return false;
    }
}