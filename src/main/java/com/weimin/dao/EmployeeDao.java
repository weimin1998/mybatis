package com.weimin.dao;

import com.weimin.pojo.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {

    Employee getEmployeeById(int id);

    int insert(Employee employee);

    int insert1(Employee employee);

    List<Employee> getAllEmployees();

    Map<String, Object> getEmployeeByIdReturnMap(int id);

    @MapKey("id")
    Map<Integer, Employee> getAllEmployeesReturnMap();


    void delete(int id);

    void update(Employee employee);
}
