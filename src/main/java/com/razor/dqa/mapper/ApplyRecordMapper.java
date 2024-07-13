package com.razor.dqa.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.razor.dqa.model.ApplyRecord;

public interface ApplyRecordMapper {

    List<ApplyRecord> selectListByRowBounds(RowBounds rowBounds);

    long selectAllCount();
}
