package com.jinshipark.gate.controller;

import com.jinshipark.gate.mapper.JinshiparkUserMapper;
import com.jinshipark.gate.model.JinshiparkUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    public static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private JinshiparkUserMapper jinshiparkUserMapper;


    @GetMapping("/hello")
    public Object hello() {
        JinshiparkUser jinshiparkUser = jinshiparkUserMapper.selectByPrimaryKey(1);
        logger.error("===jinshiparkUser====");
        logger.error("loginname:{},username:{}", jinshiparkUser.getLoginname(), jinshiparkUser.getUsername());
        return "ok";
    }
}
