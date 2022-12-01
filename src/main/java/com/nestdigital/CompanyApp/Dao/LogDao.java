package com.nestdigital.CompanyApp.Dao;

import com.nestdigital.CompanyApp.Model.LogModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LogDao extends CrudRepository<LogModel,Integer> {


    @Modifying
    @Query(value = "UPDATE `logtable` SET `logoutsec_id`=:logoutsec_id,`logouttime`=:logouttime WHERE `id`=:id",nativeQuery = true)
    public void updateLog(String logouttime,Integer logoutsec_id,Integer id);

    @Query(value = "SELECT l.`id`, l.`empid`, l.`loginsec_id`, l.`logintime`, l.`logoutsec_id`, l.`logouttime`,e.name,s.name AS loginsec_name,c.name AS logoutsec_name FROM `logtable` l JOIN employeetb e JOIN security s JOIN security c ON l.empid=e.id AND l.loginsec_id=s.id AND l.logoutsec_id=c.id",nativeQuery = true)
    public List<Map<String,String>> viewAllLogs();

    @Query(value="SELECT l.`id`, l.`empid`, l.`loginsec_id`, l.`logintime`, l.`logoutsec_id`, l.`logouttime`,e.name,s.name AS loginsec_name,c.name AS logoutsec_name FROM `logtable` l JOIN employeetb e JOIN security s JOIN security c ON l.empid=e.id AND l.loginsec_id=s.id AND l.logoutsec_id=c.id WHERE l.empid=:empid",nativeQuery = true)
    public List<Map<String,String>> viewLogByEmpId(Integer empid);


    @Query(value ="SELECT * FROM `logtable` WHERE `logoutsec_id`=0",nativeQuery = true)
    public List<LogModel> viewCheckIn();
}
