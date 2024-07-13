package com.razor.dqa.validator;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.razor.dqa.model.AssessTarget;
import com.razor.dqa.validator.fields.AfterValidator;
import com.razor.dqa.validator.fields.FieldValidator;
import com.razor.dqa.validator.fields.HouseNoValidator;
import com.razor.dqa.validator.fields.InIntValidator;
import com.razor.dqa.validator.fields.InStringValidator;
import com.razor.dqa.validator.fields.MetadataValidator;
import com.razor.dqa.validator.fields.NotNullValidator;
import com.razor.dqa.validator.fields.NumericRangeValidator;
import com.razor.dqa.validator.fields.ReleventConsistencyValidator;
import com.razor.dqa.validator.fields.UniquenessValidator;
import com.razor.dqa.validator.fields.ValidateType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnnotationBasedValidator implements DqaValidator {

    static final Map<Class<? extends AssessTarget>, Field[]> CLASS_CACHE = Maps.newHashMap(); 

    private AnnotationBasedValidator() {

    }

    private List<FieldValidator> validators = Lists.newArrayList();
    
    public void addFieldValidator(FieldValidator validator) {
        validators.add(validator);
    }

    @Override
    public DqaResult validate(AssessTarget target, DqaResult result) {
        
        Class<? extends AssessTarget> targetClass = target.getClass();
        if (!CLASS_CACHE.containsKey(targetClass)) {
            CLASS_CACHE.put(targetClass, targetClass.getDeclaredFields());
        }
        Field[] fields = CLASS_CACHE.get(targetClass);
        
        try {
            for (final Field field : fields) {
                field.setAccessible(true);
                for (FieldValidator fv : validators) {
                    if (fv.shouldApply(field)) {
                        fv.validate(field, target, result);
                    }
                }
            } 

            result.getAccessibility().getAccessibility().pass();
        } catch (Exception e) {
            log.warn("校验异常", e);
            result.getAccessibility().getAccessibility().fail(null, null);
        }

        return result;
    }

    public static AnnotationBasedValidator createWithValidateType(ValidateType... types) {

        AnnotationBasedValidator validator = new AnnotationBasedValidator();
        for (ValidateType type : types) {
            if (type == ValidateType.AFTER) {
                validator.addFieldValidator(new AfterValidator());
            }
            if (type == ValidateType.ELEMENT_NOT_NULL) {
                validator.addFieldValidator(new NotNullValidator());
            }
            if (type == ValidateType.IN_STRING) {
                validator.addFieldValidator(new InStringValidator());
            }
            if (type == ValidateType.METADATA) {
                validator.addFieldValidator(new MetadataValidator());
            }
            if (type == ValidateType.IN_INT) {
                validator.addFieldValidator(new InIntValidator());
            }
            if (type == ValidateType.RANGE) {
                validator.addFieldValidator(new NumericRangeValidator());
            }
            if (type == ValidateType.UNIQUESS) {
                validator.addFieldValidator(new UniquenessValidator());
            }
            if (type == ValidateType.RELEVENT_CONSISTENCY) {
                validator.addFieldValidator(new ReleventConsistencyValidator());
            }
            if (type == ValidateType.HOUSE_NO) {
                validator.addFieldValidator(new HouseNoValidator());
            }
        }
        return validator;
    }

}
