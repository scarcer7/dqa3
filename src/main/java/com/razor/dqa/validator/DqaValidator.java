package com.razor.dqa.validator;

import com.razor.dqa.model.AssessTarget;

public interface DqaValidator {

    DqaResult validate(AssessTarget target, DqaResult result);
}
