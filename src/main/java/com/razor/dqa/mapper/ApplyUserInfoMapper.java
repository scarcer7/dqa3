package com.razor.dqa.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.razor.dqa.model.ApplyUserInfo;

public interface ApplyUserInfoMapper {
    
    List<ApplyUserInfo> selectListByRowBounds(RowBounds rowBounds);

    long selectAllCount();
}
