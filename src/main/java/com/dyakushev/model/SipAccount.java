package com.dyakushev.model;

import com.dyakushev.constraint.FieldMatch;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "sip_account")
@FieldMatch(first = "password", second = "password2", message = "The password fields must match")
public class SipAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Username can not be blank")
    @Length(max = 20, message = "Username too long")
    private String username;
    @NotBlank(message = "Password can not be blank")
    private String password;
    @Transient
    @NotBlank(message = "Password confirmation can not be blank")
    private String password2;
    @NotBlank(message = "Domain can not be blank")
    private String domain;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
