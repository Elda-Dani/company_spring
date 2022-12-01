package com.nestdigital.CompanyApp.Controller;

import com.nestdigital.CompanyApp.Dao.LogDao;
import com.nestdigital.CompanyApp.Model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LogController {
    @Autowired
    public LogDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping("/checkIn")
    public String addLogDetails(@RequestBody LogModel log){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        log.setLogintime((String.valueOf(date.format(now))));
        dao.save(log);
        return "{status:'success'}";
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping("/checkOut")
    public String updateLogDetails(@RequestBody LogModel log){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        log.setLogouttime((String.valueOf(date.format(now))));
        dao.updateLog(log.getLogouttime(), log.getLogoutsec_id(), log.getId());
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewAllLog")
    public List<Map<String,String>> viewAllLog(){
        return (List<Map<String, String>>) dao.viewAllLogs();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/viewlog")
    public List<Map<String,String>> viewLogById(@RequestBody LogModel log){
        return (List<Map<String, String>>) dao.viewLogByEmpId(log.getEmpid());
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/viewCheckIn")
    public List<LogModel> viewCheckIn(){
        return (List<LogModel>) dao.viewCheckIn();
    }


}
