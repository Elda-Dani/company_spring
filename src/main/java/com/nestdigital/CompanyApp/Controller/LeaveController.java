package com.nestdigital.CompanyApp.Controller;


import com.nestdigital.CompanyApp.Dao.LeaveDao;
import com.nestdigital.CompanyApp.Model.LeaveModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {


    @Autowired
    private LeaveDao dao;




    @CrossOrigin("*")
    @PostMapping("/addLeave")
    public String addLeave(@RequestBody LeaveModel leave){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        leave.setAppdate((String.valueOf(date.format(now))));
        leave.setStatus(0);
        dao.save(leave);
        return "{status:'success'}";
    }



    @CrossOrigin(origins = "*")
    @PostMapping(path = "/leaveappli", consumes = "application/json", produces = "application/json")
    List<Map<String,String>> leaveappli(@RequestBody LeaveModel leave){
        return (List<Map<String,String>>) dao.View(leave.getEmpid());
    }


    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewallleaves")
    public List<Map<String,String>> viewleaves(){
        return (List<Map<String,String>>) dao.Leave();
    }


    @Transactional
    @CrossOrigin("*")
    @PostMapping("/leaveStatus")
    public String changeLeaveStatus(@RequestBody LeaveModel leave){
        dao.changeStatusOfLeave(leave.getId(), leave.getStatus());
        return "{status:'success'}'";
    }



}
