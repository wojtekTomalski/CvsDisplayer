package com.example.my_app.controllers;

import com.example.my_app.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.MalformedURLException;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service matchService;

    @GetMapping("/")
    public String getIndex(Model model) throws MalformedURLException {
        model.addAttribute("matches",matchService.getMatches());
        return "index";
    }
}