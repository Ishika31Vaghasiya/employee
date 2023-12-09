package com.employee.employee_managmet.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("test")
    public String test(){
        JSONObject resObj = new JSONObject();
        resObj.put("key", "test run successfully");
        return resObj.toString();
    }
}
