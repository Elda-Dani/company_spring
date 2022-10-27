package com.nestdigital.CompanyApp.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "security")
public class SecurityModel {
    @Id
    @GeneratedValue

    private int id;
    private String name;
    private String securitycode;
    private String doj;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecuritycode() {
        return securitycode;
    }

    public void setSecuritycode(String securitycode) {
        this.securitycode = securitycode;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
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

    public SecurityModel() {
    }


    public SecurityModel(int id, String name, String securitycode, String doj, String username, String password) {
        this.id = id;
        this.name = name;
        this.securitycode = securitycode;
        this.doj = doj;
        this.username = username;
        this.password = password;
    }
}
