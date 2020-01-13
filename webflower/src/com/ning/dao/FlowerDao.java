package com.ning.dao;

import com.ning.pojo.Flower;

import java.util.List;

public interface FlowerDao {
    /*
    * 查询全部
    * */
    List<Flower> selAll();
    /*
    * 新增
    * */
    int insFlower(Flower flower);
}
