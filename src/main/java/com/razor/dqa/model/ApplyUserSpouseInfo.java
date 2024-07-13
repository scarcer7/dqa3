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
public class ApplyUserSpouseInfo implements Serializable, AssessTarget {

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
    @NotNull
    Date updateTime;

    @Metadata
    @NotNull
    String userId;

    @Metadata
    @NotNull
    String name;

    String idCard;

    String mobile;

    String headPortraitMediaId;

    String nationalEmblemMediaId;

    @Metadata
    @RegexFormat(Const.PATTERN_SPLIT_WITH_COMMA)
    String residenceBookletMediaId;

    @Metadata
    @InInt({1, 2})
    Integer gender;

    @Metadata
    String nativePlace;

    @Metadata
    @NotNull
    String personalSignMediaId;

    @Metadata
    @NotNull
    String faceSignMediaId;

    @Metadata
    @RegexFormat(Const.PATTERN_ADMISSION_RESULT)
    String admissionResult;

    @Metadata
    String photoMediaId;

    @Metadata
    @ReleventConsistency(table = "common_area_code", column = "code")
    String registeredCode;

    @Metadata
    String registeredResidence;

    @Metadata
    String unitInfo;

    @Metadata
    @InInt({1, 2, 3, 4, 5})
    Integer userType;

    @Metadata
    @Size
    BigDecimal annualIncome;

    @Metadata
    String spouseUserId;
}
