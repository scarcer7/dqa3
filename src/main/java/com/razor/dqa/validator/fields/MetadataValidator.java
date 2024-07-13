package com.razor.dqa.validator.fields;

import java.lang.reflect.Field;

import com.razor.dqa.annotation.Metadata;
import com.razor.dqa.model.AssessTarget;
import com.razor.dqa.validator.DqaResult;

public class MetadataValidator implements FieldValidator {

    @Override
    public DqaResult validate(Field field, AssessTarget target, DqaResult result) throws IllegalArgumentException, IllegalAccessException {
        if (field.get(target) == null) return result;
        result.getNormativity().getMetaData().pass();
        return result;
    }

    @Override
    public boolean shouldApply(Field field) {
        return field.isAnnotationPresent(Metadata.class);
    }

}
