package com.razor.dqa.validator.fields;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateUtils;

import com.razor.dqa.annotation.After;
import com.razor.dqa.model.AssessTarget;
import com.razor.dqa.validator.DqaResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AfterValidator implements FieldValidator {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

    @Override
    public DqaResult validate(Field field, AssessTarget target, DqaResult result) throws IllegalArgumentException, IllegalAccessException {
        After compareWith = field.getAnnotation(After.class);
        Object d2 = field.get(target);
        if (d2 == null) return result; // 没有取值时，不用校验

        try {

            Object d1 = null;
            Field declaredField = target.getClass().getDeclaredField(compareWith.fieldName());
            declaredField.setAccessible(true);
            if (!compareWith.isRef()) {
                d1 = declaredField.get(target);
            } else {
                // TODO 暂不支持
            }
            
            if (d1 == null) {
                log.warn("@After校验失败：(" + d1 + ", " + d2 + ") [" + field.getName() + "] of " + target);
                result.getTimeliness().getTemporality().fail(target.getClass().getSimpleName() + "." + field.getName(), formatDate(d2));
                return result;
            }
            
            if (DateUtils.toCalendar(toDate(d2)).after(DateUtils.toCalendar(toDate(d1)))) {
                result.getTimeliness().getTemporality().pass();
            } else {
                log.warn("@After校验失败：(" + d1 + ", " + d2 + ") [" + field.getName() + "] of " + target);
                result.getTimeliness().getTemporality().fail(target.getClass().getSimpleName() + "." + field.getName(), formatDate(d2));
            }
        } catch (Exception e) {
            log.error("校验失败", e);
        }
        return result;
    }

    private String formatDate(Object d2) {
        if (d2 instanceof String) return (String) d2;
        return formatter.format(((Date)d2).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    private Date toDate(Object d) {
        if (d instanceof Date) return (Date) d;
        return Date.from(LocalDateTime.from(formatter.parse((String) d)).atZone(ZoneId.systemDefault()).toInstant());
    }

    
    @Override
    public boolean shouldApply(Field field) {
        return field.isAnnotationPresent(After.class);
    }

}
