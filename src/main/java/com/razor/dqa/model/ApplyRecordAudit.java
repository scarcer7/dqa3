package com.razor.dqa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.razor.dqa.annotation.After;
import com.razor.dqa.annotation.InInt;
import com.razor.dqa.annotation.InString;
import com.razor.dqa.annotation.Metadata;
import com.razor.dqa.annotation.ReleventConsistency;
import com.razor.dqa.annotation.Uniqueness;

import lombok.Data;

@Data
public class ApplyRecordAudit implements Serializable, AssessTarget{

    @Metadata
    @NotNull
    @Uniqueness
    Long id;

    @Metadata
    @NotNull
    @ReleventConsistency(table = "apply_record", column = "id")
    Long applyRecordId;

    @Metadata
    @NotNull
    @InInt({0, 1})
    Integer dataStatus;

    @Metadata
    String userId;

    @Metadata
    Long auditOrganizationId;

    @Metadata
    @InInt({1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12})
    Integer auditStepCode;

    @Metadata
    String reviewer;

    @Metadata
    @After(fieldName = "applyRecordId", isRef = true)
    Date auditTime;

    @Metadata
    @InInt({0, 1, 2})
    Integer auditStatus;

    @Metadata
    @InString({"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    String rejectedReason;

    @Metadata
    String commentsDetail;

    @Metadata
    @Size
    Integer staffTotalNum;

    @Metadata
    @Size
    BigDecimal auditQuota;

    @Metadata
    Integer loanTerm;

    @Metadata
    @Size
    BigDecimal interestRate;

    @Metadata
    @After(fieldName = "applyRecordId", isRef = true)
    Date loanTime;

    @Metadata
    Date repaymentTime;

    @Metadata
    @InInt({1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    Integer oldUserType;

    @Metadata
    @InInt({1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    Integer newUserType;

    @Metadata
    String userGuaranteeAuditMediaId;

    @Metadata
    Long bankBranch;

    @Metadata
    String userApplyAuditMediaId;

    @Metadata
    String transferReviewer;

    @Metadata
    @InInt({0, 1})
    Integer spouseSignContractOr;

    @Metadata
    @InInt({1, 2, 3, 4})
    Integer oldGuaranteeType;

    @Metadata
    @InInt({1, 2, 3, 4})
    Integer newGuaranteeType;

    @Metadata
    @After(fieldName = "applyRecordId", isRef = true)
    Date contractSignTime;

    @Metadata
    Date contractSignEndTime;
}
