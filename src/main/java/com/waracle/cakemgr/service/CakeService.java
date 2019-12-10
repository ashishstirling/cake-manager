package com.waracle.cakemgr.service;

import com.waracle.cakemgr.dao.CakeDao;
import com.waracle.cakemgr.model.Cake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class CakeService {

    @Autowired
    private CakeDao cakeDao;

    public List<Cake> getCakes() {
        return cakeDao.getAll();
    }

}
