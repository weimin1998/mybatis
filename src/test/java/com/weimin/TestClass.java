package com.weimin;


import com.weimin.dao.CatDao;
import com.weimin.dao.EmployeeDao;
import com.weimin.pojo.Cat;
import com.weimin.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class TestClass {

    public static SqlSession getSession()  {
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        return sqlSessionFactory.openSession(true);
    }
    @Before
    public void before(){

    }

    @Test
    public void test1(){
        SqlSession session = getSession();
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        Employee employee = new Employee();
        employee.setAge("22");
        employee.setName("weimin");
        int insert = mapper.insert(employee);
        System.out.println(insert);
        System.out.println(employee);
    }

    @Test
    public void test2(){
        SqlSession session = getSession();
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        Employee employeeById = mapper.getEmployeeById(2);
        System.out.println(employeeById);
    }

    @Test
    public void test3(){
        SqlSession session = getSession();
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        Employee employee = new Employee();
        employee.setAge("22");
        employee.setName("weimin");
        int insert = mapper.insert1(employee);
        System.out.println(insert);
        System.out.println(employee);
    }

    @Test
    public void test4(){
        SqlSession session = getSession();
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        List<Employee> employees = mapper.getAllEmployees();

        System.out.println(employees);
    }

    @Test
    public void test5(){
        SqlSession session = getSession();
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        Map<String, Object> map = mapper.getEmployeeByIdReturnMap(5);
        System.out.println(map);
    }

    @Test
    public void test6(){
        SqlSession session = getSession();
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        Map<Integer, Employee> map = mapper.getAllEmployeesReturnMap();
        System.out.println(map);
    }

    @Test
    public void testInsertCat(){
        SqlSession session = getSession();
        CatDao mapper = session.getMapper(CatDao.class);

        Cat cat = new Cat();
        cat.setAge("22");
        cat.setGender("man");
        cat.setName("波斯猫");
        mapper.insertCat(cat);
        System.out.println(cat);
    }

    @Test
    public void testResult(){
        SqlSession session = getSession();
        CatDao mapper = session.getMapper(CatDao.class);

        System.out.println(mapper);
        Cat catById = mapper.getCatById(1);
        System.out.println(catById);
    }

    @Test
    public void testSelectOne(){
        SqlSession session = getSession();

        Object o = session.selectOne("com.weimin.dao.StudentDao.getStudentById", 1);

        System.out.println(o);
    }

    @Test
    public void testDemo(){
        SqlSession session = getSession();

        EmployeeDao mapper = session.getMapper(EmployeeDao.class);

        mapper.delete(7);

        Employee employee = new Employee();
        employee.setId(8);
        employee.setName("name8");
        employee.setAge("23");
        mapper.update(employee);
    }
}
