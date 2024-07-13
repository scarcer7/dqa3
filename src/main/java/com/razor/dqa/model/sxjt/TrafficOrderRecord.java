package com.razor.dqa.model.sxjt;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.razor.dqa.annotation.NumericCompareWith;
import com.razor.dqa.annotation.InInt;
import com.razor.dqa.annotation.Metadata;
import com.razor.dqa.annotation.RegexFormat;
import com.razor.dqa.annotation.Uniqueness;
import com.razor.dqa.annotation.type.Comparison;
import com.razor.dqa.annotation.type.Operator;
import com.razor.dqa.model.AssessTarget;

import lombok.Data;

@Data
public class TrafficOrderRecord  implements Serializable, AssessTarget {

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
    String billId;

    @Metadata
    @NotNull
    @Uniqueness
    String uuid;

    @Metadata
    @NotNull
    String companyCode;

    @Metadata
    @NotNull
    @RegexFormat("^JT\\d{19}$")
    String parkingCode;

    String plateNo;

    @Metadata
    @NotNull
    @InInt({1, 2, 3, 4, 5})
    Integer plateColor;

    @Metadata
    @NotNull
    Date billTime;

    @NotNull
    @Metadata
    @Range(min = 0)
    Integer chargeFee;

    @Metadata
    @Range(min = 0)
    Integer discountAmount;

    @Metadata
    String couponId;

    @Metadata
    @NotNull
    @NumericCompareWith(comparison = Comparison.EQUAL, fieldName = "charge_fee", 
        isOperation = true, secondFieldName = "discount_amount", operator = Operator.MINUS)
    Integer shouldPay;

    @Metadata
    @NotNull
    @Range(min = 0)
    Integer actualPay;

    @Metadata
    @NotNull
    @RegexFormat("^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]) (?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$")
    String dealTime;

    @Metadata
    @InInt({1, 2, 3, 4, 5, 6, 7})
    Integer paidType;
    
    @InInt({101, 102, 201, 202, 203, 204, 205, 206, 207, 208, 209, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310})
    @Metadata
    Integer payType;

    @Metadata
    @InInt({0, 1})
    Integer billWay;

    @Metadata
    @NotNull
    Date uploadTime;

    @Metadata
    @NotNull
    String inId;

    @Metadata
    @NotNull
    String outId;

    @Metadata
    @NotNull
    @InInt({1, 2, 3})
    Integer payStatus;

    @Metadata
    @NotNull
    @InInt({1, 2})
    Integer invoiceStatus;

    @Metadata
    @NotNull
    @InInt({0, 1})
    Integer delFlag;

    @Metadata
    String couponCode;

}
