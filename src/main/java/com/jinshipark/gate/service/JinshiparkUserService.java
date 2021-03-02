package com.jinshipark.gate.service;


import com.jinshipark.gate.bo.JinshiparkUserBO;
import com.jinshipark.gate.utils.JinshiparkJSONResult;

public interface JinshiparkUserService {
    JinshiparkJSONResult login(JinshiparkUserBO jinshiparkUserBO);
}
