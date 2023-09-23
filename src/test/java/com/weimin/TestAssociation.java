package com.weimin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.weimin.association.dao.EmployeeDao;
import com.weimin.association.dao.TeacherDao;
import com.weimin.association.pojo.Employee;
import com.weimin.association.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestAssociation {

    public static SqlSessionFactory getSessionFactory()  {
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1(){
        SqlSessionFactory sessionFactory = getSessionFactory();
        SqlSession session = sessionFactory.openSession(true);
        SqlSession session1 = sessionFactory.openSession(true);

        EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
        EmployeeDao employeeDao1 = session1.getMapper(EmployeeDao.class);


        Employee employee1 = employeeDao.getEmployeeAndDeptById(2);
        System.out.println(employee1);
        session.close();


        Employee employee2 = employeeDao1.getEmployeeAndDeptById(2);
        System.out.println(employee2);

        session1.close();
    }


    @Test
    public void test2(){
        SqlSession session = getSessionFactory().openSession(true);
        EmployeeDao employeeDao = session.getMapper(EmployeeDao.class);
        Employee employee = employeeDao.getEmployeeAndDeptByIdStep(3);
        System.out.println(employee.getName());
    }

    @Test
    public void test3(){
        SqlSession session = getSessionFactory().openSession(true);

        TeacherDao mapper = session.getMapper(TeacherDao.class);
        System.out.println(mapper.getClass());

        Teacher teacher= mapper.getById(1);

        System.out.println(teacher);
    }

    @Test
    public void test4(){
        SqlSession session = getSessionFactory().openSession(true);

        TeacherDao mapper = session.getMapper(TeacherDao.class);

        Teacher teacher = mapper.getByIdStep(2);

        System.out.println(teacher.getName());
        System.out.println(teacher.getName());
    }

    @Test
    public void testPage(){
        SqlSession session = getSessionFactory().openSession(true);
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);

        Page<Object> page = PageHelper.startPage(1, 2);
        List<Employee> employees = mapper.getAll();

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println(page.getPageNum());
        System.out.println(page.getTotal());
        System.out.println(page.getPageSize());
        System.out.println(page.getPages());

    }
}
