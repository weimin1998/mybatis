package com.weimin.dao;

import com.weimin.pojo.Cat;

public interface CatDao {

    Cat getCatById(int id);
    int insertCat(Cat cat);
}
