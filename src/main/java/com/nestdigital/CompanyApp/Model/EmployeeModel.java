package com.nestdigital.CompanyApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeetb")

public class EmployeeModel {
    @Id
    @GeneratedValue


    private int id;
    private String name;
    private String empcode;
    private String doj;
    private String designation;
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

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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

    public EmployeeModel() {
    }

    public EmployeeModel(int id, String name, String empcode, String doj, String designation, String username, String password) {
        this.id = id;
        this.name = name;
        this.empcode = empcode;
        this.doj = doj;
        this.designation = designation;
        this.username = username;
        this.password = password;
    }
}
