package com.briup.crm.dao;

import com.briup.crm.common.bean.Userpatient;
import com.briup.crm.common.bean.UserpatientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserpatientMapper {
    int countByExample(UserpatientExample example);

    int deleteByExample(UserpatientExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userpatient record);

    int insertSelective(Userpatient record);

    List<Userpatient> selectByExample(UserpatientExample example);

    Userpatient selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userpatient record, @Param("example") UserpatientExample example);

    int updateByExample(@Param("record") Userpatient record, @Param("example") UserpatientExample example);

    int updateByPrimaryKeySelective(Userpatient record);

    int updateByPrimaryKey(Userpatient record);
    
    List<Userpatient> findAllUserpatient(@Param("userId")Integer id);
    
    List<Userpatient> findUserpatient(@Param("userId")Integer id);
}