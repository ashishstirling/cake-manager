package com.waracle.cakemgr.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CakeTest {

    private Cake cake;

    @Before
    public void setup() {
        cake = new Cake();
    }

    @Test
    public void idTest() {
        long expected = 1;
        cake.setId(expected);
        long actual = cake.getId();
        assertEquals(actual, expected);
    }

    @Test
    public void titleTest() {
        String expected = "Vanilla Cake";
        cake.setTitle(expected);
        String actual = cake.getTitle();
        assertEquals(actual, expected);
    }

    @Test
    public void descTest() {
        String expected = "Plain vanilla cake";
        cake.setDesc(expected);
        String actual = cake.getDesc();
        assertEquals(actual, expected);
    }

    @Test
    public void imageTest() {
        String expected = "https://hg-images.condecdn.net/image/oJ0RWZ6DdL3/crop/600/f/apr-10_simple-vanilla-cake_b.jpg";
        cake.setImage(expected);
        String actual = cake.getImage();
        assertEquals(actual, expected);
    }

}
