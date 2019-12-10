package com.waracle.cakemgr.dao;


import com.waracle.cakemgr.model.Cake;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class CakeDaoTest {

    @Autowired
    CakeDao cakeDao;

    public long createCake() {
        long id = 0;
        Cake cake = new Cake();
        cake.setTitle("Vanilla cake");
        cake.setDesc("Basic vanilla cake");
        cake.setImage("https://hg-images.condecdn.net/image/oJ0RWZ6DdL3/crop/600/f/apr-10_simple-vanilla-cake_b.jpg");
        return cakeDao.save(cake);
    }

    @Test
    public void saveTest() {
        cakeDao.truncate();
        List<Cake> actualList = cakeDao.getAll();
        assertThat(actualList.size(), is(0));
        createCake();
        actualList = cakeDao.getAll();
        assertThat(actualList.size(), is(1));
    }

    @Test
    public void getAllTest() {
        cakeDao.truncate();
        createCake();
        List<Cake> actualList = cakeDao.getAll();
        assertNotNull(actualList);
    }

    @Test
    public void truncateTest() {
        cakeDao.truncate();
        List<Cake> actualList = cakeDao.getAll();
        assertThat(actualList.size(), is(0));
    }

}
