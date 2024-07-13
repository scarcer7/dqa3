package com.razor.dqa.validator.helper;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.razor.dqa.mapper.CommonAreaCodeMapper;
import com.razor.dqa.model.CommonAreaCode;

@Component
public class ConsistencyHelper {

    public static final String COMMON_AREA_CODE_CODE = "common_area_code.code";

    public static final String APPLY_RECORD_ID = "apply_record.id";

    public static final String APPLY_REOCRD_CREATE_TIME_PREFIX = "apply_record.create_time.";

    private static final int STEP = 100;

    @Autowired
    CommonAreaCodeMapper commonAreaCodeMapper;

    private Map<String, Set<Object>> RELEVENT_CODE_CACHE = Maps.newHashMap();

    private Map<String, Date> APPLY_CREATE_TIME_CACHE = Maps.newHashMap();

    @PostConstruct
    public void init() {
        // 初始化地区代码
        long commonAreaCodeCount = commonAreaCodeMapper.selectAllCount();
        RELEVENT_CODE_CACHE.put(COMMON_AREA_CODE_CODE, Sets.newHashSet());
        for (int i = 0; i < commonAreaCodeCount; i += STEP) {
            List<CommonAreaCode> rows = commonAreaCodeMapper.selectListByRowBounds(new RowBounds(i, STEP));
            RELEVENT_CODE_CACHE.get(COMMON_AREA_CODE_CODE).addAll(Lists.transform(rows, new Function<CommonAreaCode,Object>() {

                @Override
                public Object apply(CommonAreaCode arg0) {
                    return arg0.getCode();
                }
                
            }));
        }

    }

    public boolean checkReleventConsistency(String key, Object value) {
        if (!RELEVENT_CODE_CACHE.containsKey(key)) return false;
        return RELEVENT_CODE_CACHE.get(key).contains(value);
    }

    public void put(String key, Object value) {
        if (!RELEVENT_CODE_CACHE.containsKey(key)) {
            RELEVENT_CODE_CACHE.put(key, Sets.newHashSet());
        }
        RELEVENT_CODE_CACHE.get(key).add(value);
    }

    public void putApplyTime(String key, Date value) {
        APPLY_CREATE_TIME_CACHE.put(key, value);
    }

    public Date getApplyTime(String key) {
        return APPLY_CREATE_TIME_CACHE.get(key);
    }
}
