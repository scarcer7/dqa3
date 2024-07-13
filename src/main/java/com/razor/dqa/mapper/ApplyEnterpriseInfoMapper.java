package com.razor.dqa.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.razor.dqa.model.ApplyEnterpriseInfo;

public interface ApplyEnterpriseInfoMapper {

    List<ApplyEnterpriseInfo> selectListByRowBounds(RowBounds rowBounds);

    long selectAllCount();    
}
