package com.razor.dqa.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.razor.dqa.model.ApplyRecordAudit;

public interface ApplyRecordAuditMapper {

    List<ApplyRecordAudit> selectListByRowBounds(RowBounds rowBounds);

    long selectAllCount();    
}
