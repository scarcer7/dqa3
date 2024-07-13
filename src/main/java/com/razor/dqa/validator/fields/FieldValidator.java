package com.razor.dqa.validator.fields;

import java.lang.reflect.Field;

import com.razor.dqa.model.AssessTarget;
import com.razor.dqa.validator.DqaResult;

public interface FieldValidator {

    DqaResult validate(Field field, AssessTarget target, DqaResult result) throws IllegalArgumentException, IllegalAccessException;

    boolean shouldApply(Field field);

}
