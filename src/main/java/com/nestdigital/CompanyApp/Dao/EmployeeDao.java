package com.nestdigital.CompanyApp.Dao;

import com.nestdigital.CompanyApp.Model.EmployeeModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {

    @Query(value = "SELECT `id`, `designation`, `doj`, `empcode`, `name`, `password`, `username` FROM `employeetb` WHERE `name`=:name",nativeQuery = true)
    List<EmployeeModel> searchEmployee(String name);

    @Modifying
    @Query(value = "DELETE FROM `employeetb` WHERE `id`=:id",nativeQuery = true)
    void deleteEmployeeById(Integer id);

    @Modifying
    @Query(value = "UPDATE `employeetb` SET `designation`=:designation ,`doj`=:doj,`empcode`=:empcode,`name`=:name,`password`=:password,`username`=:username WHERE `id`=:id",nativeQuery = true)
    void updateemp(String name,String empcode,String designation,String doj,String password,String username, Integer id);

    @Query(value = "SELECT `id`, `designation`, `doj`, `empcode`, `name`, password,username FROM `employeetb` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<EmployeeModel> log(String username,String password);


}
