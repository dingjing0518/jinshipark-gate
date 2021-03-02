package com.jinshipark.gate.controller;

import com.jinshipark.gate.bo.JinshiparkUserBO;
import com.jinshipark.gate.service.JinshiparkUserService;
import com.jinshipark.gate.utils.JinshiparkJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理类
 */
@Controller
@RequestMapping("/user")
public class JinshiparkUserController {

    @Autowired
    private JinshiparkUserService jinshiparkUserService;

    /**
     * 登录
     * @param jinshiparkUserBO 参数实体
     * @return 处理结果
     */
    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseBody
    public JinshiparkJSONResult login(@RequestBody JinshiparkUserBO jinshiparkUserBO) {
        return jinshiparkUserService.login(jinshiparkUserBO);
    }
}
