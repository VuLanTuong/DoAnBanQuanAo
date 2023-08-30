package com.example.doanbanquanao.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class LogOutController {

    @PostMapping("/logout")
    public String logoutHandler(HttpServletRequest request, HttpServletResponse response) {
        // Retrieve the authentication object from the security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Create an instance of SecurityContextLogoutHandler
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();

        // Call the clearAuthentication method to clear the authentication
        logoutHandler.logout(request, response, authentication);

        // Optionally, invalidate the session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Redirect the user to the desired page after logout
        return "redirect:/homepage";
    }
}
