package com.nestdigital.CompanyApp.Dao;

import com.nestdigital.CompanyApp.Model.EmployeeModel;
import com.nestdigital.CompanyApp.Model.SecurityModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecurityDao extends CrudRepository<SecurityModel,Integer> {


    @Query(value = "SELECT `id`, `doj`, `name`, `password`, `securitycode`, `username` FROM `security` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<SecurityModel> logg(String username, String password);


    @Query(value = "SELECT `id`, `doj`, `name`, `password`, `securitycode`, `username` FROM `security` WHERE `name`=:name",nativeQuery = true)
    List<SecurityModel> searchsecurity(String name);

    @Modifying
    @Query(value = "DELETE FROM `security` WHERE `id`=:id",nativeQuery = true)
    void deleteById(Integer id);

    @Modifying
    @Query(value = "UPDATE `security` SET `doj`=:doj,`name`=:name,`password`=:password,`securitycode`=:securitycode,`username`=:username WHERE `id`=:id",nativeQuery = true)
    void editsec(String name,String securitycode,String doj,String password,String username, Integer id);

}
