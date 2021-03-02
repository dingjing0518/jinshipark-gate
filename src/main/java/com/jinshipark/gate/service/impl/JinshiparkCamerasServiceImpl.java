package com.jinshipark.gate.service.impl;

import com.jinshipark.gate.mapper.JinshiparkCamerasMapper;
import com.jinshipark.gate.model.JinshiparkCameras;
import com.jinshipark.gate.model.JinshiparkCamerasExample;
import com.jinshipark.gate.service.JinshiparkCamerasService;
import com.jinshipark.gate.utils.JinshiparkJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JinshiparkCamerasServiceImpl implements JinshiparkCamerasService {
    @Autowired
    private JinshiparkCamerasMapper jinshiparkCamerasMapper;

    @Override
    public JinshiparkJSONResult list(String parkId) {
        JinshiparkCamerasExample example = new JinshiparkCamerasExample();
        JinshiparkCamerasExample.Criteria criteria = example.createCriteria();
        criteria.andParkidEqualTo(parkId);
        List<JinshiparkCameras> list = jinshiparkCamerasMapper.selectByExample(example);
        return JinshiparkJSONResult.ok(list);
    }

    @Override
    public JinshiparkJSONResult openGateSend(Integer id) {
        JinshiparkCameras record = new JinshiparkCameras();
        record.setStatus("0");
        record.setId(id);
        jinshiparkCamerasMapper.updateByPrimaryKeySelective(record);
        return JinshiparkJSONResult.ok();
    }

    @Override
    public JinshiparkJSONResult closeGateSend(Integer id) {
        JinshiparkCameras record = new JinshiparkCameras();
        record.setStatus("1");
        record.setId(id);
        jinshiparkCamerasMapper.updateByPrimaryKeySelective(record);
        return JinshiparkJSONResult.ok();
    }
}
