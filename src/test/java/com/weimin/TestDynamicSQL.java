package com.weimin;

import com.weimin.association.dao.EmployeeDao;
import com.weimin.association.pojo.Department;
import com.weimin.association.pojo.Employee;
import com.weimin.dao.DynamicSQL;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestDynamicSQL {
    public static SqlSession getSession() {
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

    @Test
    public void test() {
        SqlSession session = getSession();

        EmployeeDao mapper = session.getMapper(EmployeeDao.class);

        mapper.dynamicQuery(1, "a", null, null);


    }

    @Test
    public void testUpdate() {
        SqlSession session = getSession();

        EmployeeDao mapper = session.getMapper(EmployeeDao.class);

        Employee employee = new Employee();
        employee.setId(10);
        employee.setAge("100");
        employee.setName("aaa");
        Department department = new Department();
        department.setId(6);
        employee.setDept(department);

        mapper.dynamicUpdate(employee);

    }
}
