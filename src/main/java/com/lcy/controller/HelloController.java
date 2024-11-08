package com.lcy.controller;

import com.lcy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuweijin
 * @desc
 * @date 2021-12-20 16:34
 */
@RestController
public class HelloController {

    @Autowired
    private UserMapper mapper;

    @GetMapping("/hello")
    public String sayHello(){




        return "Hello java";
    }







}
