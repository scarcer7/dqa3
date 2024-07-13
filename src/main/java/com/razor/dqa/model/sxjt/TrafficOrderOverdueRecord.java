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
public class TrafficOrderOverdueRecord implements Serializable, AssessTarget {

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
    @Uniqueness
    @NotNull
    String uid;

    @Metadata
    @NotNull
    @Uniqueness
    String billId;

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
    Date inTime;

    @Metadata
    @NotNull
    Date outTime;

    @Metadata
    @NotNull
    String createTime;

    @Metadata
    @NotNull
    @Range(min = 0)
    Integer shouldPay;

    @Metadata
    @NotNull
    @Range(min = 0)
    Integer actualPay;

    @Metadata
    @NotNull
    @Range(min = 0)
    Integer unPay;

    @Metadata
    @NotNull
    @InInt({1, 2, 3})
    Integer status;

    // 0 未缴费离场（原新版路路使用的欠费类型） 1 平台未收到扣费请求 2 平台未发起扣费请求 3 支付渠道未响应扣费请求 4 未付费离开 5 无感支付失败(0和4对应的后端处理逻辑一致) 1000 车位欠费默认类型 2000 稽核欠费默认类型 3000 扎帐欠费默认类型
    @Metadata
    @InInt({0, 1, 2, 3, 4, 5, 1000, 2000, 3000})
    Integer unPayType;

    @Metadata
    String parkingSpaceCode;

    String phone;

    @Metadata
    @Range(min = 0)
    Integer payInBack;

    //1 现金 2 微信 3 支付宝 4 银联 5 ETC 6 龙支付 7 被扫
    @Metadata
    @InInt({1, 2, 3, 4, 5, 6, 7})
    Integer paidType;

    @Metadata
    @Range(min = 0)
    Integer checkMoney;

    @Metadata
    Integer checkType;

    @Metadata
    @NotNull
    @RegexFormat("^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]) (?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$")
    String uploadTime;

    @Metadata
    @NotNull
    @InInt({0, 1})
    Integer delFlag;

    @Metadata
    @NotNull
    String companyCode;

    @Metadata
    @NotNull
    @InInt({1, 2})
    Integer invoiceStatus;

    // 1. 追缴补缴2. 用户主动补缴3. 管理后台补缴4. 历史补缴
    @Metadata
    @NotNull
    @InInt({1, 2, 3, 4})
    Integer payType;

    @Metadata
    String payParkingName;
    
    @Metadata
    Date payTime;

}
