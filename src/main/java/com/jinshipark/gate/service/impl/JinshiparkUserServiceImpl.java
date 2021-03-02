package com.jinshipark.gate.service.impl;


import com.jinshipark.gate.bo.JinshiparkUserBO;
import com.jinshipark.gate.mapper.JinshiparkUserMapper;
import com.jinshipark.gate.model.JinshiparkUser;
import com.jinshipark.gate.model.JinshiparkUserExample;
import com.jinshipark.gate.service.JinshiparkUserService;
import com.jinshipark.gate.utils.JinshiparkJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JinshiparkUserServiceImpl implements JinshiparkUserService {

    @Autowired
    private JinshiparkUserMapper jinshiparkUserMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public JinshiparkJSONResult login(JinshiparkUserBO jinshiparkUserBO) {
        if (StringUtils.isBlank(jinshiparkUserBO.getLoginName()) || StringUtils.isBlank(jinshiparkUserBO.getPassword())) {
            return JinshiparkJSONResult.errorMsg("用户名或者密码不能为空");
        }
        JinshiparkUserExample example = new JinshiparkUserExample();
        JinshiparkUserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginnameEqualTo(jinshiparkUserBO.getLoginName());
        long count = jinshiparkUserMapper.countByExample(example);
        if (count < 1) {
            return JinshiparkJSONResult.errorMsg("用户名不存在");
        }
        criteria.andPasswordEqualTo(jinshiparkUserBO.getPassword());
        List<JinshiparkUser> list = jinshiparkUserMapper.selectByExample(example);
        if (null == list || list.size() == 0) {
            return JinshiparkJSONResult.errorMsg("密码错误");
        }
        return JinshiparkJSONResult.ok(list.get(0));
    }
}
