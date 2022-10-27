package com.nestdigital.CompanyApp.Controller;

import com.nestdigital.CompanyApp.Dao.EmployeeDao;
import com.nestdigital.CompanyApp.Model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee",consumes = "application/json",produces = "application/json")
    public String addemployee(@RequestBody EmployeeModel emp){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        emp.setDoj(currentdate);
        System.out.println(emp.toString());
        dao.save(emp);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewemployee")
    public List<EmployeeModel> viewemployee(){

        return (List<EmployeeModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchemployee",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel> searchEmployee(@RequestBody EmployeeModel emp){
        return (List<EmployeeModel>) dao.searchEmployee(emp.getName());
    }


    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/deleteemployee",consumes = "application/json",produces = "application/json")
    public String deleteemployee(@RequestBody EmployeeModel emp)
    {
        dao.deleteEmployeeById(emp.getId());
        return "{status:'success'}";
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updateemp",consumes = "application/json",produces = "application/json")
    public String updateemp(@RequestBody EmployeeModel emp){
        dao.updateemp(emp.getName(),emp.getEmpcode(),emp.getDoj(),emp.getDesignation(),emp.getUsername(),emp.getPassword(),emp.getId());
        return "{status='success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/emplogin",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel> emplogin(@RequestBody EmployeeModel login){
        return (List<EmployeeModel>) dao.log(login.getUsername(),login.getPassword());
    }




}
