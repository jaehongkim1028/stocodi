package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class accountController {

    public String createAccount(Model model) {

        return "account/new";
    }

}
