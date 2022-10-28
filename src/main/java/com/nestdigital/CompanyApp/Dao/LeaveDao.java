package com.nestdigital.CompanyApp.Dao;

import com.nestdigital.CompanyApp.Model.LeaveModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<LeaveModel,Integer> {


    @Query(value = "SELECT l.`id`, l.`appdate`, l.`date`, l.`duration`, l.`empid`, l.`reason`, l.`status`, l.`type`,e.name FROM `leaveapp` l JOIN employeetb e ON e.`id`=l.empid WHERE l.empid=:empid",nativeQuery = true)
    List<Map<String,String>> View(Integer empid);


    @Query(value = "SELECT l.`id`, l.`appdate`, l.`date`, l.`duration`, l.`empid`, l.`reason`, l.`status`, l.`type`,e.name FROM `leaveapp` l JOIN employeetb e ON e.`id`=l.empid",nativeQuery = true)
    List<Map<String,String>> Leave();


    @Modifying
    @Query(value = "UPDATE `leaveapp` SET `status`=:status WHERE `id`=:id",nativeQuery = true)
    void changeStatusOfLeave(Integer id,Integer status);



}
