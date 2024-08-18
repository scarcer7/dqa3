package com.razor.dqa.validator.helper;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

@Component
public class ConsistencyHelper {

    private Map<String, Set<Object>> RELEVENT_CODE_CACHE = Maps.newHashMap();

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

}
