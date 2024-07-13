package com.razor.dqa.validator.fields;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.razor.dqa.annotation.RegexFormat;
import com.razor.dqa.model.AssessTarget;
import com.razor.dqa.validator.DqaResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegexFormatValidator implements FieldValidator {

    @Override
    public DqaResult validate(Field field, AssessTarget target, DqaResult result) throws IllegalArgumentException, IllegalAccessException {
        
        Pattern p = Pattern.compile(field.getAnnotation(RegexFormat.class).value());
        Object obj = field.get(target);
        if (obj == null) return result;
        String value = String.valueOf(obj);
        Matcher m = p.matcher(value);
        if (m.matches()) {
            result.getAccuracy().getFormatCompliance().pass();
        } else {
            log.warn("@RegexFormat校验失败：(" + p.toString() + ", " + value + ") [" + field.getName() + "] of " + target);
            result.getAccuracy().getFormatCompliance().fail(target.getClass().getSimpleName() + "." + field.getName(), value);
        }
        return result;
    }

    @Override
    public boolean shouldApply(Field field) {
        return field.isAnnotationPresent(RegexFormat.class);
    }

}
