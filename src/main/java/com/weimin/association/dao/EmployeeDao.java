package com.weimin.association.dao;


import com.weimin.association.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {

    Employee getEmployeeAndDeptById(int id);
    Employee getEmployeeAndDeptByIdStep(int id);

    Employee dynamicQuery(@Param("id") Integer id,
                          @Param("name") String name,
                          @Param("age") String age,
                          @Param("did") Integer did);

    void dynamicUpdate(Employee employee);

    List<Employee> getAll();
}
