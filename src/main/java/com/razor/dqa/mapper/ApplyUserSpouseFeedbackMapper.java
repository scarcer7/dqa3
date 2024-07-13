package com.razor.dqa.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.razor.dqa.model.ApplyUserSpouseFeedback;

public interface ApplyUserSpouseFeedbackMapper {

    List<ApplyUserSpouseFeedback> selectListByRowBounds(RowBounds rowBounds);

    long selectAllCount();
}
