package com.razor.dqa.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.razor.dqa.model.ApplyUserSpouseInfo;

public interface ApplyUserSpouseInfoMapper {
    
    List<ApplyUserSpouseInfo> selectListByRowBounds(RowBounds rowBounds);

    long selectAllCount();

}
