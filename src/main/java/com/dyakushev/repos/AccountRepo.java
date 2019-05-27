package com.dyakushev.repos;

import com.dyakushev.model.SipAccount;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<SipAccount, Long> {

    SipAccount findByUsername(String username);
}
