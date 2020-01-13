package com.ning.service.impl;

import com.ning.dao.FlowerDao;
import com.ning.dao.impl.FlowerDaoImpl;
import com.ning.pojo.Flower;
import com.ning.service.FlowerService;

import java.util.List;

public class FlowerServiceImpl implements FlowerService {
    private FlowerDao flowerDao = new FlowerDaoImpl();
    @Override
    public List<Flower> show() {
        return flowerDao.selAll();
    }

    @Override
    public int add(Flower flower) {
        return flowerDao.insFlower(flower);
    }
}
