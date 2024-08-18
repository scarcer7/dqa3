package com.razor.dqa.model.sxjt;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.razor.dqa.annotation.After;
import com.razor.dqa.annotation.InInt;
import com.razor.dqa.annotation.Metadata;
import com.razor.dqa.annotation.RegexFormat;
import com.razor.dqa.annotation.Uniqueness;
import com.razor.dqa.model.AssessTarget;

import lombok.Data;

@Data
public class TrafficCarRecord  implements Serializable, AssessTarget {

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

    @Metadata
    @NotNull
    @InInt({0, 1})
    Integer delFlag;

    @Metadata
    @NotNull
    String companyCode;

    @Metadata
    @NotNull
    @RegexFormat("^JT\\d{19}$")
    String parkingCode;

    @Metadata
    @NotNull
    @Uniqueness
    String uid;

    @Metadata
    @NotNull
    String inId;

    @Metadata
    String outId;

    String plateNo;

    @Metadata
    String inGateCode;

    @Metadata
    String inOperatorCode;

    @Metadata
    String inNum;

    @Metadata
    String outGateCode;

    @Metadata
    String outOperatorCode;

    @Metadata
    String outNum;

    @Metadata
    @NotNull
    @RegexFormat("^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]) (?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$")
    String inTime;

    @Metadata
    @After(fieldName = "inTime")
    @RegexFormat("^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]) (?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$")
    String outTime;

    @Metadata
    @NotNull
    @InInt({1, 2, 3})
    Integer parkingType;

    @Metadata
    @NotNull
    @InInt({1, 2, 3, 4, 5})
    Integer plateColor;

    @Metadata
    @Range(min = 0)
    Integer chargeFee;

    @Metadata
    @Range(min = 0)
    Integer shouldPay;

    String inUrl;

    String outUrl;

    @Metadata
    @NotNull
    @InInt({1, 2})
    Integer parkingState;

    @Metadata
    @NotNull
    Date uploadTime;
}
