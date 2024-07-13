package com.razor.dqa.model.sxjt;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.razor.dqa.annotation.After;
import com.razor.dqa.annotation.InInt;
import com.razor.dqa.annotation.Metadata;
import com.razor.dqa.annotation.Uniqueness;
import com.razor.dqa.model.AssessTarget;

import lombok.Data;

@Data
public class TrafficMemberCardPayRecord implements Serializable, AssessTarget {

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

    String billId;

    String cardId;

    String plateNo;

    String userPhone;

    @Metadata
    @NotNull
    String cardName;

    @Metadata
    @InInt({1, 2, 3, 4})
    @NotNull
    Integer cardUnit;

    @Metadata
    @Range(min = 0)
    @NotNull
    Integer cardNumber;

    @Metadata
    @Range(min = 0)
    @NotNull
    Integer cardPrice;

    @Metadata
    @Range(min = 0)
    @NotNull
    Integer cardTotalPrice;

    @Metadata
    @NotNull
    Date startTime;

    @Metadata
    @NotNull
    @After(fieldName = "startTime")
    Date endTime;

    @Metadata
    @NotNull
    @InInt({1, 2, 3})
    Integer status;

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
