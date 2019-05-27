package com.dyakushev.controller;

import com.dyakushev.model.LoginForm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class MainController {


    @GetMapping(value = {"/main", "/"})
    public String main() {
        return "main";
    }

    @PostMapping("/login")
    public String validateLogin(
            @Valid @ModelAttribute("loginform") LoginForm loginForm,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            if (!StringUtils.isEmpty(loginForm.getUsername()))
                model.addAttribute("username", loginForm.getUsername());
            return "login";
        } else
            return "main";
    }

    @GetMapping("/login")
    public String login(
            @ModelAttribute("loginform") LoginForm loginForm
    ) {
        return "login";

    }

    // Login form with error
    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }


}
