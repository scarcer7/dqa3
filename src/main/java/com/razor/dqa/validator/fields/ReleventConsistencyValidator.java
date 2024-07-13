package com.razor.dqa.validator.fields;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;

import com.razor.dqa.annotation.ReleventConsistency;
import com.razor.dqa.model.AssessTarget;
import com.razor.dqa.validator.DqaResult;
import com.razor.dqa.validator.helper.ConsistencyHelper;
import com.razor.dqa.validator.helper.SpringContextHolder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReleventConsistencyValidator implements FieldValidator {

    @Override
    public DqaResult validate(Field field, AssessTarget target, DqaResult result) throws IllegalArgumentException, IllegalAccessException {

        Object value = field.get(target);
        if (value == null) return result;

        ConsistencyHelper consistencyHelper = SpringContextHolder.getBean(ConsistencyHelper.class);
        
        ReleventConsistency releventConsistency = field.getAnnotation(ReleventConsistency.class);
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotBlank(releventConsistency.schema())) {
            sb.append(releventConsistency.schema()).append(".");
        }
        sb.append(releventConsistency.table()).append(".").append(releventConsistency.column());        

        if (consistencyHelper.checkReleventConsistency(sb.toString(), value)) {
            result.getConsistency().getReleventData().pass();
        } else {
            log.warn("@ReleventConsistency校验失败：(" + value + ") [" + field.getName() + "] of " + target);
            result.getConsistency().getReleventData().fail(target.getClass().getSimpleName() + "." + field.getName(), value);
        }

        return result;    
    }

    @Override
    public boolean shouldApply(Field field) {
        return field.isAnnotationPresent(ReleventConsistency.class);
    }

}
