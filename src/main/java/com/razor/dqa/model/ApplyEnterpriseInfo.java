package com.razor.dqa.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import com.razor.dqa.annotation.InInt;
import com.razor.dqa.annotation.Metadata;
import com.razor.dqa.annotation.ReleventConsistency;
import com.razor.dqa.annotation.Uniqueness;

import lombok.Data;

@Data
public class ApplyEnterpriseInfo implements Serializable, AssessTarget {

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
    String registrationNo;

    @Metadata
    String organizationCode;

    @Metadata
    @NotNull
    String socialCreditCode;

    @Metadata
    @NotNull
    String name;

    @Metadata
    @NotNull
    String administrativeRegion;

    @Metadata
    @NotNull
    String address;

    @Metadata
    @NotNull
    String businessScope;

    @Metadata
    Integer staffTotalNum;

    @Metadata
    @NotNull
    String enterpriseLicenseMediaId;

    @Metadata
    @NotNull
    String legalPersonName;

    @Metadata
    String categoryName;

    @Metadata
    String categoryCode;

    @Metadata
    Date establishDate;

    @Metadata
    Date validityStartDate;

    @Metadata
    Date validityEndDate;

    @Metadata
    String registeredCapital;

    @Metadata
    String status;

    @Metadata
    String statusCode;

    @Metadata
    Integer shareholderNum;

    @Metadata
    String businessPlaceMediaId;

    @Metadata
    String otherMediaId;

}
