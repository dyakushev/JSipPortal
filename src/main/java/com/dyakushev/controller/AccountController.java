package com.dyakushev.controller;

import com.dyakushev.model.SipAccount;
import com.dyakushev.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public String accountList(Model model) {
        model.addAttribute("accounts", accountService.findAll());
        return "configuration/accountList";
    }

    @PostMapping("/edit/{id}")
    public String saveEditAccount(
            @PathVariable Long id,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String password2,
            @RequestParam String domain) {
        accountService.saveEditAccount(id, username, password, password2, domain);
        return "redirect:/account";
    }

    @GetMapping("/remove/{id}")
    public String removeAccount(@PathVariable Long id) {
        SipAccount account = accountService.findById(id);
        if (account != null)
            accountService.removeAccount(account);
        return "redirect:/account";
    }

    @GetMapping("/edit/{id}")
    public String accountEditForm(@PathVariable Long id, Model model) {
        SipAccount account = accountService.findById(id);
        model.addAttribute("account", account);
        return "configuration/accountEdit";
    }

    @GetMapping("/new")
    public String newAccountForm(@ModelAttribute("account") SipAccount account) {
        return "configuration/accountNew";
    }

    @PostMapping("/new")
    public String saveNewAccount(
            @Valid @ModelAttribute("account") SipAccount account,
            BindingResult bindingResult

    ) {
        if (bindingResult.hasErrors()) {
           /* Map<String, String> errorMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorMap);*/
            //   model.addAttribute("username", account.getUsername());
            //  model.addAttribute("username", account.getUsername());

            return "configuration/accountNew";
        } else {

            accountService.saveNewAccount(account);
        }
        return "redirect:/account";
    }


}
