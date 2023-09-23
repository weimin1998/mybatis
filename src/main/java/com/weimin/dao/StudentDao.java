package com.weimin.dao;

import com.weimin.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    Student getStudentById(String id);
    Student getStudentByIdAndNameWithAnnotation(@Param("id") String id, @Param("name") String name);
    Student getStudentByIdAndNameNoAnnotation(String id, String name);
    Student getStudentByIdAndNameList(List list);
    Student getStudentByIdAndNameMap(Map map);
    Student getStudentByIdAndNamePojo(Student student);
}
