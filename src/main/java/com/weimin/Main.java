package com.weimin;

import com.weimin.dao.StudentDao;
import com.weimin.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = getSession();

        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        System.out.println(mapper);

        Student studentById = mapper.getStudentById("1");
        System.out.println(studentById);

        System.out.println(mapper.getStudentByIdAndNameNoAnnotation("1", "weimin"));

        System.out.println(mapper.getStudentByIdAndNameWithAnnotation("1", "weimin"));

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("id","1");
        map.put("name","weimin");
        System.out.println(mapper.getStudentByIdAndNameMap(map));

        ArrayList<String> strings = new ArrayList<String>();
        strings.add("1");
        strings.add("weimin");
        System.out.println(mapper.getStudentByIdAndNameList(strings));

        Student student = new Student();
        student.setId("1");
        student.setName("weimin");
        System.out.println(mapper.getStudentByIdAndNamePojo(student));


    }

    public static SqlSession getSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        return sqlSessionFactory.openSession();
    }
}
