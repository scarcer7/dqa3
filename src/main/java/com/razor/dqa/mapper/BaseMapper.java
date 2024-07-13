package com.razor.dqa.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.razor.dqa.model.AssessTarget;

public interface BaseMapper<T extends AssessTarget> {
    
    List<T> selectListByRowBounds(RowBounds rowBounds);

    long selectAllCount();

    public static int STEP = 100;
}
