package com.razor.dqa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.razor.dqa.annotation.InInt;
import com.razor.dqa.annotation.Metadata;
import com.razor.dqa.annotation.RegexFormat;
import com.razor.dqa.annotation.ReleventConsistency;
import com.razor.dqa.annotation.Uniqueness;
import com.razor.dqa.validator.Const;

import lombok.Data;

@Data
public class ApplyUserInfo implements Serializable, AssessTarget {

    @NotNull
    @Metadata
    @Uniqueness
    Long id;

    @NotNull
    @Metadata
    @ReleventConsistency(table = "apply_record", column = "id")
    Long applyRecordId;

    @NotNull
    @Metadata
    String userId;

    @NotNull
    @Metadata
    @InInt({0, 1})
    Integer dataStatus;

    @NotNull
    @Metadata
    Date updateTime;

    @NotNull
    @Metadata
    @InInt({1, 2, 3, 4, 5})
    Integer userType;

    @Metadata
    @NotNull
    String name;

    String idCard;

    @Metadata
    @NotNull
    @InInt({1, 2})
    Integer gender;

    @Metadata
    @InInt({1, 2, 3, 4})
    Integer politicsStatus;

    @Metadata
    String nativePlace;

    @Metadata
    @ReleventConsistency(table = "common_area_code", column = "code")
    String registeredCode;

    @Metadata
    String registeredResidence;

    @Metadata
    @ReleventConsistency(table = "common_area_code", column = "code")
    String liveCode;

    @Metadata
    String liveAddress;

    String headPortraitMediaId;

    String nationalEmblemMediaId;

    @Metadata
    @RegexFormat(Const.PATTERN_SPLIT_WITH_COMMA)
    String residenceBookletMediaId;

    @Metadata
    @InInt({1, 2, 3, 4})
    Integer marriageStatus;

    @Metadata
    @InInt({0, 1, 2, 3})
    Integer marriageFeedbackStatus;

    @Metadata
    @RegexFormat(Const.PATTERN_SPLIT_WITH_COMMA)
    String marriageMediaId;

    @Metadata
    String photoMediaId;

    @Metadata
    @InInt({1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    Integer userLoanType;

    @Metadata
    @RegexFormat(Const.PATTERN_SPLIT_WITH_COMMA)
    String userLoanTypeSupplementMediaId;

    @Metadata
    @Size(min = 0, max = 500000)
    BigDecimal applyQuota;

    @Metadata
    String employmentPermitMediaId;

    @Metadata
    @NotNull
    String personalSignMediaId;

    @Metadata
    @NotNull
    String faceSignMediaId;

    @Metadata
    String promiseSignMediaId;

    @Metadata
    @RegexFormat(Const.PATTERN_ADMISSION_RESULT)
    String admissionResult;

    @Metadata
    @InInt({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 301, 302, 303, 304, 305, 101, 102, 103})
    Integer userAuditStatus;

    @Metadata
    Date permissionTime;

    @Metadata
    @Size(min = 0)
    Integer historicalLendingCount;

    @Metadata
    @InInt({1, 0})
    Integer enterpriseLoanApplyingOr;

    @Metadata
    @InInt({0, 1, 2})
    Integer submitStatus;

    @Metadata
    String unitInfo;

    @Metadata
    String socialInsuranceMonth;

    @Metadata
    String socialInsuranceNo;

    @Metadata
    String userGuaranteeAuditMediaId;

    @Metadata
    String userApplyAuditMediaId;

    @Metadata
    String financingContractNumber;

    @Metadata
    String financingContractMediaId;

    @Metadata
    @Size(min = 0)
    BigDecimal annualIncome;

    @Metadata
    @RegexFormat("^\\d{13,19}$")
    String loanBankCard;
}
