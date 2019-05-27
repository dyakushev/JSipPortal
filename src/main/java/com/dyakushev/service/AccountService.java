package com.dyakushev.service;

import com.dyakushev.model.SipAccount;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.dyakushev.repos.AccountRepo;


@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Iterable<SipAccount> findAll() {
        return accountRepo.findAll();
    }

    public SipAccount findById(Long id) {
        return accountRepo.findById(id).get();
    }

    public SipAccount findByUsername(String username) {
        return accountRepo.findByUsername(username);
    }


    public void saveNewAccount(SipAccount account) {
        SipAccount account2 = findByUsername(account.getUsername());
        if (account2 == null) {
            if (account.getPassword().equals(account.getPassword2())) {
                accountRepo.save(account);
            }
        }
    }

    public void saveEditAccount(Long id, String username, String password, String password2, String domain) {
        SipAccount account = findById(id);
        if (account == null)
            return;
        if (!StringUtils.isEmpty(username))
            account.setUsername(username);
        if (!StringUtils.isEmpty(password) && !StringUtils.isEmpty(password2) && password.equals(password2))
            account.setPassword(password);
        if (!StringUtils.isEmpty(domain))
            account.setDomain(domain);
        accountRepo.save(account);
    }

    public void removeAccount(SipAccount account) {
        accountRepo.delete(account);
    }
}
