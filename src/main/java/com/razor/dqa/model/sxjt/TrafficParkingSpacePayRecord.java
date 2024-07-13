package com.razor.dqa.model.sxjt;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.razor.dqa.annotation.InInt;
import com.razor.dqa.annotation.Metadata;
import com.razor.dqa.annotation.RegexFormat;
import com.razor.dqa.annotation.Uniqueness;
import com.razor.dqa.model.AssessTarget;

import lombok.Data;

@Data
public class TrafficParkingSpacePayRecord implements Serializable, AssessTarget {

    @Metadata
    @NotNull
    @Uniqueness
    String id;

    @Metadata
    @NotNull
    Date createDate;

    @Metadata
    @NotNull
    Date updateDate;

    String userParkingSpaceId;

    String billId;

    String userId;

    String userName;

    String userPhone;

    String plateNo;

    @Metadata
    @InInt({1, 2, 3, 4, 5})
    Integer plateColor;

    @Metadata
    @RegexFormat("^JT\\d{19}$")
    String parkingCode;

    @Metadata
    @RegexFormat("^JTQY\\d{19}$")
    String areaCode;

    @Metadata
    @NotNull
    String parkingSpaceNmber;

    @Metadata
    @NotNull
    Date parkingSpaceStartTime;

    @Metadata
    @NotNull
    Date parkingSpaceEndTime;

    @Metadata
    @NotNull
    @InInt({1, 2, 3})
    Integer chargingUnit;

    @Metadata
    @NotNull
    @Range(min = 1)
    Integer chargingNumber;

    @Metadata
    @NotNull
    @Range(min = 0)
    Integer payTotalPrice;

    @Metadata
    @NotNull
    @InInt({1, 2})
    Integer invoiceStatus;

    @Metadata
    @NotNull
    @InInt({1, 2})
    Integer noticeStatus;

    @Metadata
    @NotNull
    @InInt({0, 1})
    Integer delFlag;
}
