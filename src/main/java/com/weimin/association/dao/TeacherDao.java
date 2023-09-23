package com.weimin.association.dao;

import com.weimin.association.pojo.Teacher;

public interface TeacherDao {
    Teacher getById(int id);
    Teacher getByIdStep(int id);
}
