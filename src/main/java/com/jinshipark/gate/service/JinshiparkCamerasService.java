package com.jinshipark.gate.service;

import com.jinshipark.gate.utils.JinshiparkJSONResult;

public interface JinshiparkCamerasService {
    JinshiparkJSONResult list(String parkId);

    JinshiparkJSONResult openGateSend(Integer id);

    JinshiparkJSONResult closeGateSend(Integer id);
}
