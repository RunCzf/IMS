package com.briup.crm.dao;

import com.briup.crm.common.bean.Patientdrug;
import com.briup.crm.common.bean.PatientdrugExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PatientdrugMapper {
    int countByExample(PatientdrugExample example);

    int deleteByExample(PatientdrugExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Patientdrug record);

    int insertSelective(Patientdrug record);

    List<Patientdrug> selectByExample(PatientdrugExample example);

    Patientdrug selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Patientdrug record, @Param("example") PatientdrugExample example);

    int updateByExample(@Param("record") Patientdrug record, @Param("example") PatientdrugExample example);

    int updateByPrimaryKeySelective(Patientdrug record);

    int updateByPrimaryKey(Patientdrug record);
}