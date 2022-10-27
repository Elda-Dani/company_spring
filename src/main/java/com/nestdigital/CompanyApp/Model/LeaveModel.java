package com.nestdigital.CompanyApp.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leaveapp")
public class LeaveModel {


        @Id
        @GeneratedValue

        private int id;
        private int empid;
        private String date;

        private String reason;
        private String duration;
        private String appdate;
        private String type;


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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAppdate() {
        return appdate;
    }

    public void setAppdate(String appdate) {
        this.appdate = appdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LeaveModel() {
    }

    public LeaveModel(int id, int empid, String date, String reason, String duration, String appdate, String type) {
        this.id = id;
        this.empid = empid;
        this.date = date;
        this.reason = reason;
        this.duration = duration;
        this.appdate = appdate;
        this.type = type;
    }
}

