package com.razor.dqa.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.razor.dqa.model.ApplyGuaranteeInfo;

public interface ApplyGuaranteeInfoMapper {

    List<ApplyGuaranteeInfo> selectListByRowBounds(RowBounds rowBounds);

    long selectAllCount();    
}
