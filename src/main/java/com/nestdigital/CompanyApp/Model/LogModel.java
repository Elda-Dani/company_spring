package com.nestdigital.CompanyApp.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logtable")
public class LogModel {
@Id
@GeneratedValue


    private int id;

    private int empid;
    private int loginsec_id;
    private int logoutsec_id;
    private String logintime;
    private String logouttime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getLoginsec_id() {
        return loginsec_id;
    }

    public void setLoginsec_id(int loginsec_id) {
        this.loginsec_id = loginsec_id;
    }

    public int getLogoutsec_id() {
        return logoutsec_id;
    }

    public void setLogoutsec_id(int logoutsec_id) {
        this.logoutsec_id = logoutsec_id;
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }

    public String getLogouttime() {
        return logouttime;
    }

    public void setLogouttime(String logouttime) {
        this.logouttime = logouttime;
    }

    public LogModel() {
    }

    public LogModel(int id, int empid, int loginsec_id, int logoutsec_id, String logintime, String logouttime) {
        this.id = id;
        this.empid = empid;
        this.loginsec_id = loginsec_id;
        this.logoutsec_id = logoutsec_id;
        this.logintime = logintime;
        this.logouttime = logouttime;
    }
}
