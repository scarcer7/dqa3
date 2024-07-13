package com.razor.dqa.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.razor.dqa.annotation.InInt;
import com.razor.dqa.annotation.Metadata;
import com.razor.dqa.annotation.RegexFormat;
import com.razor.dqa.annotation.ReleventConsistency;
import com.razor.dqa.annotation.Uniqueness;
import com.razor.dqa.validator.Const;

import lombok.Data;

@Data
public class ApplyUserSpouseFeedback implements Serializable, AssessTarget {

    @NotNull
    @Metadata
    @Uniqueness
    Long id;

    @Metadata
    @NotNull
    @ReleventConsistency(table = "apply_record", column = "id")
    Long applyRecordId;

    @Metadata
    @NotNull
    String userId;

    @Metadata
    String name;

    String idCard;

    String headPortraitMediaId;

    String nationalEmblemMediaId;

    @Metadata
    @InInt({1, 2})
    Integer gender;

    @Metadata
    @NotNull
    @InInt({1, 2, 3, 4})
    Integer feedbackMarriageType;

    @Metadata
    @RegexFormat(Const.PATTERN_SPLIT_WITH_COMMA)
    String marriageSupplementMediaId;

    @Metadata
    @InInt({0, 1, 2})
    Integer auditStatus;

    @Metadata
    String auditDetail;

    @Metadata
    @NotNull
    @InInt({0, 1})
    Integer dataStatus;

    @Metadata
    @NotNull
    Date createTime;

    @Metadata
    @NotNull
    Date updateTime;
}
