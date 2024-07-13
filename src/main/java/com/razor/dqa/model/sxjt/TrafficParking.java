package com.razor.dqa.model.sxjt;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.razor.dqa.annotation.InInt;
import com.razor.dqa.annotation.Metadata;
import com.razor.dqa.annotation.NumericCompareWith;
import com.razor.dqa.annotation.RegexFormat;
import com.razor.dqa.annotation.Uniqueness;
import com.razor.dqa.annotation.type.Comparison;
import com.razor.dqa.model.AssessTarget;

import lombok.Data;

@Data
public class TrafficParking implements Serializable, AssessTarget {

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
    @RegexFormat("^JT\\d{19}$")
    String parkingCode;

    @Metadata
    @NotNull
    String companyCode;

    @Metadata
    String aliParkingCode;

    @Metadata
    String thirdParkingCode;

    @Metadata
    @NotNull
    String parkingName;

    String contacts;

    String contactPhone;

    @Metadata
    @NotNull
    String provinceId;

    @Metadata
    @NotNull
    String cityId;

    @Metadata
    @NotNull
    String districtId;

    @Metadata
    @NotNull
    String streetId;

    @Metadata
    @NotNull
    String address;

    @Metadata
    @NotNull
    Double longitude;

    @Metadata
    @NotNull
    Double latitude;

    @NotNull
    @Metadata
    @Range(min = 0)
    Integer totalBerthNum;

    @NotNull
    @Metadata
    @Range(min = 0)
    @NumericCompareWith(fieldName = "totalBerthNum", comparison = Comparison.NOT_GREATER_THAN)
    Integer fixedBerthNum;

    @Metadata
    @NotNull
    @Range(min = 0)
    @NumericCompareWith(fieldName = "totalBerthNum", comparison = Comparison.NOT_GREATER_THAN)
    Integer tempBerthNum;
    
    @Metadata
    @NotNull
    @Range(min = 0)
    @NumericCompareWith(fieldName = "totalBerthNum", comparison = Comparison.NOT_GREATER_THAN)
    Integer balanceBerthNum;

    String parkingUrl;

    @Metadata
    String openTime;

    @Metadata
    @NotNull
    @InInt({1, 2})
    Integer onlineType;

    @Metadata
    @InInt({1, 2})
    Integer reservationType;

    @Metadata
    @InInt({1, 2})
    Integer parkingSpaceLease;

    @Metadata
    @InInt({1, 2})
    Integer noFeelType;

    @Metadata
    @InInt({1, 2})
    Integer shareType;

    @Metadata
    @InInt({1, 2})
    Integer chargeType;

    @Metadata
    String rateInfo;

    @Metadata
    @Range(min = 0)
    Integer prePayFreeTime;

    @Metadata
    String orderKeepParam;

    @Metadata
    @Range(min = 0)
    Integer orderCancel;

    @Metadata
    @Range(min = 0)
    Integer orderBreak;

    @Metadata
    @InInt({1, 2})
    Integer parkingType;

    @Metadata
    @InInt({1, 2})
    Integer guidanceScreenType;

    @Metadata
    @InInt({2, 3})
    Integer guidanceScreenLevel;

    @Metadata
    Double starLevel;

    @Metadata
    @InInt({0, 1})
    Integer delFlag;

    @Metadata
    String guidanceScreenId;

    @Metadata
    Integer parkingDirId;

    @Metadata
    String advancePaymentQrCode;

    @Metadata
    @InInt({1, 2})
    Integer qrCodeStatus;

    @Metadata
    @InInt({1, 2})
    Integer areaQrCodeStatus;

    @Metadata
    String areaAdvancePaymentQrCode;

    @Metadata
    String siteNo;

    @Metadata
    Long settlementId;

    @Metadata
    String chargeBindParkingCode;

    @Metadata
    @InInt({1, 2})
    Integer directChargeType;
}
