package com.nestdigital.CompanyApp.Dao;

import com.nestdigital.CompanyApp.Model.EmployeeModel;
import com.nestdigital.CompanyApp.Model.SecurityModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecurityDao extends CrudRepository<SecurityModel,Integer> {


    @Query(value = "SELECT `id`, `doj`, `name`, `password`, `securitycode`, `username` FROM `security` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<SecurityModel> logg(String username, String password);
}
