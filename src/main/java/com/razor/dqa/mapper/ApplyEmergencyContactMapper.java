package com.razor.dqa.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.razor.dqa.model.ApplyEmergencyContact;

public interface ApplyEmergencyContactMapper {

    List<ApplyEmergencyContact> selectListByRowBounds(RowBounds rowBounds);

    long selectAllCount(); 
}
