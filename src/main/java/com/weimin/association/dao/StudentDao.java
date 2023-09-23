package com.weimin.association.dao;

import com.weimin.association.pojo.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getByTid(int tid);
}
