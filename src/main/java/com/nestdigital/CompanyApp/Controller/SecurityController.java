package com.nestdigital.CompanyApp.Controller;


import com.nestdigital.CompanyApp.Dao.SecurityDao;

import com.nestdigital.CompanyApp.Model.EmployeeModel;
import com.nestdigital.CompanyApp.Model.SecurityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController

public class SecurityController {


    @Autowired
    private SecurityDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addsecurity",consumes = "application/json",produces = "application/json")
    public String addsecurity(@RequestBody SecurityModel emp){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        emp.setDoj(currentdate);
        System.out.println(emp.toString());
        dao.save(emp);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewsecurity")
    public List<SecurityModel> viewsecurity(){

        return (List<SecurityModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/securitylogin",consumes = "application/json",produces = "application/json")
    public List<SecurityModel> securitylogin(@RequestBody SecurityModel login){
        return (List<SecurityModel>) dao.logg(login.getUsername(),login.getPassword());
    }





}
