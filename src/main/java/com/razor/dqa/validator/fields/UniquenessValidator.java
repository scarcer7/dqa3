package com.razor.dqa.validator.fields;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.razor.dqa.annotation.Uniqueness;
import com.razor.dqa.model.AssessTarget;
import com.razor.dqa.validator.DqaResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UniquenessValidator implements FieldValidator {

    static final Map<String, Set<Object>> UNIQUENESS_CACHE = Maps.newHashMap();


    @Override
    public DqaResult validate(Field field, AssessTarget target, DqaResult result) throws IllegalArgumentException, IllegalAccessException {
        
        field.setAccessible(true);
        Object value = field.get(target);

        if (value == null) return result;

        String id = "@" + target.getClass().getSimpleName() + "@" + field.getName();
        if (!UNIQUENESS_CACHE.containsKey(id)) {
            UNIQUENESS_CACHE.put(id, Sets.newHashSet());
        }

        if (UNIQUENESS_CACHE.get(id).contains(value)) {
            log.warn("@Uniqueness校验失败：(" + value + ") [" + field.getName() + "] of " + target);
            result.getAccuracy().getUniqueness().fail(target.getClass().getSimpleName() + "." + field.getName(), value);
            result.getAccuracy().getDuplicationRate().fail(target.getClass().getSimpleName() + "." + field.getName(), value);
        } else {
            UNIQUENESS_CACHE.get(id).add(value);
            result.getAccuracy().getUniqueness().pass();
            result.getAccuracy().getDuplicationRate().pass();
        }

        return result;
    }

    @Override
    public boolean shouldApply(Field field) {
        return field.isAnnotationPresent(Uniqueness.class);
    }

}
