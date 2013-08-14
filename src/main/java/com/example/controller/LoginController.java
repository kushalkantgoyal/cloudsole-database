package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {

       
    @RequestMapping(value="")
    public String loginToCloudSoleDevelop(Map<String, Object> map) 
    {
        return "login";
    }
}
