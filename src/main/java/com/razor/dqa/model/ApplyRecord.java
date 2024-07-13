package com.razor.dqa.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.razor.dqa.annotation.After;
import com.razor.dqa.annotation.InInt;
import com.razor.dqa.annotation.InString;
import com.razor.dqa.annotation.Metadata;
import com.razor.dqa.annotation.Uniqueness;

import lombok.Data;

@Data
public class ApplyRecord implements Serializable, AssessTarget {
    
    @Uniqueness
    @NotNull
    @Metadata
    Long id;

    @NotNull
    @Metadata
    String userId;

    @NotNull
    @Metadata
    @InInt({0, 1})
    Integer dataStatus;

    @InInt({1, 2})
    @Metadata
    Integer applyType;

    @InInt({0, 1, 2})
    @Metadata
    Integer applyStatus;

    @InInt({1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 101, 201, 202, 301})
    @Metadata
    Integer auditStatus;

    @Metadata
    Long enterpriseId;

    @Metadata
    Long bank;

    @Metadata
    Long bankBranch;

    @Size(min = 0, max = 36)
    @Metadata
    Integer loanTerm;

    @NotNull
    @Metadata
    Date createTime;

    @Metadata
    Date updateTime;

    @After(fieldName = "createTime")
    @Metadata
    Date endTime;

    @Metadata
    String processInstanceId;

    @NotNull
    @InString({"personal_business_loan_guarantee", "personal_business_loan_no_guarantee", "personal_business_loan_guarantee_contract", "personal_business_loan_no_guarantee_contract"})
    @Metadata
    String processKeyType;

    @Metadata
    String financingContractName;
}
