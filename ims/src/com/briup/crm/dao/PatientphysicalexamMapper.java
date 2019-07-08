package com.briup.crm.dao;

import com.briup.crm.common.bean.Patientphysicalexam;
import com.briup.crm.common.bean.PatientphysicalexamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PatientphysicalexamMapper {
    int countByExample(PatientphysicalexamExample example);

    int deleteByExample(PatientphysicalexamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Patientphysicalexam record);

    int insertSelective(Patientphysicalexam record);

    List<Patientphysicalexam> selectByExample(PatientphysicalexamExample example);

    Patientphysicalexam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Patientphysicalexam record, @Param("example") PatientphysicalexamExample example);

    int updateByExample(@Param("record") Patientphysicalexam record, @Param("example") PatientphysicalexamExample example);

    int updateByPrimaryKeySelective(Patientphysicalexam record);

    int updateByPrimaryKey(Patientphysicalexam record);
}