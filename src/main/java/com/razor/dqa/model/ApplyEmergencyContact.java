package com.razor.dqa.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.razor.dqa.annotation.InInt;
import com.razor.dqa.annotation.InString;
import com.razor.dqa.annotation.Metadata;
import com.razor.dqa.annotation.ReleventConsistency;
import com.razor.dqa.annotation.Uniqueness;

import lombok.Data;

@Data
public class ApplyEmergencyContact implements Serializable, AssessTarget {

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
    String userId;

    @Metadata
    @NotNull
    @InInt({0, 1})
    Integer dataStatus;

    @Metadata
    @NotNull
    Date updateTime;
    
    @Metadata
    String contactName;

    String contactPhone;

    @Metadata
    @InString({"1", "2", "3", "4", "5", "6", "7"})
    String contactRelationship;
}
