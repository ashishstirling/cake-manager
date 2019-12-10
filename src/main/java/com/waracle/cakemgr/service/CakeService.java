package com.waracle.cakemgr.service;

import com.waracle.cakemgr.dao.CakeDao;
import com.waracle.cakemgr.model.Cake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CakeService {

    @Autowired
    private CakeDao cakeDao;

    public List<Cake> getCakes() {
        return cakeDao.getAll();
    }

    public Long postCakes(Cake cake) {
        return cakeDao.save(cake);
    }
}
