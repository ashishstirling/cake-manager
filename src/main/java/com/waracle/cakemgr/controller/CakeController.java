package com.waracle.cakemgr.controller;

import com.waracle.cakemgr.model.Cake;
import com.waracle.cakemgr.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CakeController {

    @Autowired
    private CakeService cakeService;

    @GetMapping(path="/cakes")
    public List<Cake> getCakes() {
        return cakeService.getCakes();
    }

}
