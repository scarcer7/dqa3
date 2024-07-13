package com.razor.dqa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.razor.dqa.annotation.HouseNo;
import com.razor.dqa.annotation.InInt;
import com.razor.dqa.annotation.Metadata;
import com.razor.dqa.annotation.RegexFormat;
import com.razor.dqa.annotation.ReleventConsistency;
import com.razor.dqa.annotation.Uniqueness;
import com.razor.dqa.validator.Const;

import lombok.Data;

@Data
public class ApplyGuaranteeInfo implements Serializable, AssessTarget{

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
    @InInt({1, 2, 3, 4})
    Integer guaranteeType;

    @Metadata
    @InInt({1, 2})
    Integer guarantorType;

    @Metadata
    @InInt({1, 2})
    Integer mortgagorType;

    @Metadata
    @InInt({1, 2})
    Integer collateralRegionType;

    @Metadata
    @InInt({1, 2})
    Integer houseType;

    @Metadata
    @HouseNo
    String houseNo;

    @Metadata
    @RegexFormat(Const.PATTERN_SPLIT_WITH_COMMA)
    String guaranteeSupplementMediaId;

    @Metadata
    BigDecimal houseLoanPrincipal;

    @Metadata
    String loanPrincipalMediaId;

    @Metadata
    String houseAddress;

    @Metadata
    BigDecimal houseEvaluationPrice;

    @Metadata
    BigDecimal houseArea;

    @Metadata
    @InInt({0, 1})
    Integer houseSoleOwnerOr;

    @Metadata
    String depositReceiptNumber;

    @Metadata
    String houseOwner;

    String sendInfoMobile;

    String sendSpouseInfoMobile;

}
