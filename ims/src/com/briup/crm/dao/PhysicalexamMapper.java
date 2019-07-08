package com.briup.crm.dao;

import com.briup.crm.common.bean.Physicalexam;
import com.briup.crm.common.bean.PhysicalexamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhysicalexamMapper {
    int countByExample(PhysicalexamExample example);

    int deleteByExample(PhysicalexamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Physicalexam record);

    int insertSelective(Physicalexam record);

    List<Physicalexam> selectByExample(PhysicalexamExample example);

    Physicalexam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Physicalexam record, @Param("example") PhysicalexamExample example);

    int updateByExample(@Param("record") Physicalexam record, @Param("example") PhysicalexamExample example);

    int updateByPrimaryKeySelective(Physicalexam record);

    int updateByPrimaryKey(Physicalexam record);
}