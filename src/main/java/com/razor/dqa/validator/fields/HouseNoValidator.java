package com.razor.dqa.validator.fields;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

import com.razor.dqa.annotation.HouseNo;
import com.razor.dqa.model.AssessTarget;
import com.razor.dqa.validator.DqaResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HouseNoValidator implements FieldValidator{

    Pattern pattern1 = Pattern.compile("^[\\u4e00-\\u9fa5]+\\(\\d{4}\\)[\\u4e00-\\u9fa5]+第\\d+号$");

    Pattern pattern2 = Pattern.compile("^\\d{7}$");

    @Override
    public DqaResult validate(Field field, AssessTarget target, DqaResult result) throws IllegalArgumentException, IllegalAccessException {
        // 抵押物类型为1数据格式：鄂(2016)宜昌市不动产权第0038301号
        // 抵押为类型为2数据格式：0291785 （7位数字）
        
        Object value = field.get(target);
        if (value == null) return result;

        try {
            Field f = target.getClass().getDeclaredField("houseType");
            f.setAccessible(true);
            Object type = f.get(target);
            if (type != null) {
                Integer t = (Integer) type;
                boolean testResult = false;
                if (t.intValue() == 1) {
                    testResult = pattern1.matcher((String) value).matches();
                } else if (t.intValue() == 2) {
                    testResult = pattern2.matcher((String) value).matches();
                } else {
                    log.warn("@HouseNo校验失败：(" + value + ") [" + field.getName() + "] of " + target);
                    return result;
                }
                if (testResult) {
                    result.getNormativity().getBusinessRule().pass();
                } else {
                    log.warn("@HouseNo校验失败：(" + value + ") [" + field.getName() + "] of " + target);
                    result.getNormativity().getBusinessRule().fail(target.getClass().getSimpleName() + "." + field.getName(), value);
                }
            }
        } catch (Exception e) {
            log.error("@HouseNo校验失败：(" + value + ") [" + field.getName() + "] of " + target, e);
        }

        return result;
    }

    @Override
    public boolean shouldApply(Field field) {
        return field.isAnnotationPresent(HouseNo.class);
    }

}
