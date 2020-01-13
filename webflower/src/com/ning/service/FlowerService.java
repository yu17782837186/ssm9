package com.ning.service;

import com.ning.pojo.Flower;

import java.util.List;

public interface FlowerService {
    /*
    * 显示所有花卉信息
    * */
    List<Flower> show();
    /*
    * 新增
    * */
    int add(Flower flower);
}
