package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {

    @ModelAttribute("user")
    public User setUpUserFrom() {
        return new User();
    }

    @GetMapping("/dologin")
    public String Index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("CookieValue", cookie);
        return "login";
    }

    @PostMapping("dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model,
                          @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie = new Cookie("setUser", setUser);
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
            if (user.getEmail() != null) {
                setUser = user.getEmail();

                cookie.setMaxAge(24 * 60 * 60);
                response.addCookie(cookie);
                model.addAttribute("message", "Login success. Welcome ");
            }
            } else {
            user.setEmail("");
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "login";
    }
}

