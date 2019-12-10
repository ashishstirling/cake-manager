package com.waracle.cakemgr.service;

import com.waracle.cakemgr.model.Cake;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class CakeServiceTest {

    @Autowired
    CakeService cakeService;

    @Test
    public void getCakesTest() {
        List<Cake> actualList = cakeService.getCakes();
        assertNotNull(actualList);
    }

    @Test
    public void postCakesTest() {
        Cake cake = new Cake();
        cake.setTitle("Vanilla cake");
        cake.setDesc("Basic vanilla cake");
        cake.setImage("https://hg-images.condecdn.net/image/oJ0RWZ6DdL3/crop/600/f/apr-10_simple-vanilla-cake_b.jpg");
        long id = cakeService.postCakes(cake);
        assertNotEquals(0, id);
    }
}
