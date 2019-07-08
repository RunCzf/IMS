package com.briup.crm.dao;

import com.briup.crm.common.bean.Drug;
import com.briup.crm.common.bean.DrugExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DrugMapper {
    int countByExample(DrugExample example);

    int deleteByExample(DrugExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Drug record);

    int insertSelective(Drug record);

    List<Drug> selectByExample(DrugExample example);
    
    List<Drug> findAllDrug();

    Drug selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Drug record, @Param("example") DrugExample example);

    int updateByExample(@Param("record") Drug record, @Param("example") DrugExample example);

    int updateByPrimaryKeySelective(Drug record);

    int updateByPrimaryKey(Drug record);
}