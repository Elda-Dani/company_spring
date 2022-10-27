package com.nestdigital.CompanyApp.Controller;


import com.nestdigital.CompanyApp.Dao.LeaveDao;
import com.nestdigital.CompanyApp.Model.LeaveModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {


    @Autowired
    private LeaveDao dao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "addleave",consumes = "application/json",produces = "application/json")
    public String addleave(@RequestBody LeaveModel leave){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        leave.setAppdate(currentdate);
        System.out.println(leave.toString());
        dao.save(leave);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/leaveappli", consumes = "application/json", produces = "application/json")
    List<Map<String,String>> leaveappli(@RequestBody LeaveModel leave){
        return (List<Map<String,String>>) dao.View(leave.getEmpid());
    }


    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewleaves")
    public List<Map<String,String>> viewleaves(){
        return (List<Map<String,String>>) dao.Leave();
    }



}
