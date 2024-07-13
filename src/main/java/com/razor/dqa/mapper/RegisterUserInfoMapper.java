package com.razor.dqa.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.razor.dqa.model.RegisterUserInfo;

public interface RegisterUserInfoMapper {

    List<RegisterUserInfo> selectListByRowBounds(RowBounds rowBounds);

    long selectAllCount();
}
