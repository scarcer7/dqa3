package com.razor.dqa.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.razor.dqa.model.CommonAreaCode;

public interface CommonAreaCodeMapper {
    
    List<CommonAreaCode> selectListByRowBounds(RowBounds rowBounds);

    long selectAllCount();
}
