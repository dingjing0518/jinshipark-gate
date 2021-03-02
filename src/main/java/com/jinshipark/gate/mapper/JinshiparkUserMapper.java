package com.jinshipark.gate.mapper;

import com.jinshipark.gate.model.JinshiparkUser;
import com.jinshipark.gate.model.JinshiparkUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JinshiparkUserMapper {
    long countByExample(JinshiparkUserExample example);

    int deleteByExample(JinshiparkUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JinshiparkUser record);

    int insertSelective(JinshiparkUser record);

    List<JinshiparkUser> selectByExample(JinshiparkUserExample example);

    JinshiparkUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JinshiparkUser record, @Param("example") JinshiparkUserExample example);

    int updateByExample(@Param("record") JinshiparkUser record, @Param("example") JinshiparkUserExample example);

    int updateByPrimaryKeySelective(JinshiparkUser record);

    int updateByPrimaryKey(JinshiparkUser record);
}