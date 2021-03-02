package com.jinshipark.gate.controller;

import com.jinshipark.gate.service.JinshiparkCamerasService;
import com.jinshipark.gate.utils.JinshiparkJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/camera")
public class JinshiparkCamerasController {
    @Autowired
    private JinshiparkCamerasService jinshiparkCamerasService;

    @PostMapping(value = "/list")
    @ResponseBody
    public JinshiparkJSONResult list(@RequestParam("parkId") String parkId) {
        return jinshiparkCamerasService.list(parkId);
    }

    @GetMapping(value = "/openGateSend")
    @ResponseBody
    public JinshiparkJSONResult openGateSend(@RequestParam("id") Integer id) {
        return jinshiparkCamerasService.openGateSend(id);
    }

    @GetMapping(value = "/closeGateSend")
    @ResponseBody
    public JinshiparkJSONResult closeGateSend(@RequestParam("id") Integer id) {
        return jinshiparkCamerasService.closeGateSend(id);
    }
}
