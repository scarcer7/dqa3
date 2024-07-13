package com.razor.dqa.model.sxjt;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.razor.dqa.annotation.InInt;
import com.razor.dqa.annotation.InString;
import com.razor.dqa.annotation.Metadata;
import com.razor.dqa.annotation.ReleventConsistency;
import com.razor.dqa.annotation.Uniqueness;
import com.razor.dqa.model.AssessTarget;

import lombok.Data;

@Data
public class TrafficMemberCard  implements Serializable, AssessTarget {

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
    String companyCode;

    String cardId;

    @Metadata
    @NotNull
    String cardName;

    @Metadata
    @NotNull
    @InInt({1, 2, 3, 4})
    Integer cardUnit;

    @Metadata
    @NotNull
    @Range(min = 0)
    Integer cardPrice;

    @Metadata
    @InInt({1, 2})
    Integer cardDiscount;

    @Metadata
    @Range(min = 0)
    Integer giftDay;

    @Metadata
    @Range(min = 0)
    Integer maxNumber;

    @Metadata
    @NotNull
    @InString({"0", "1", "2", "3", "4", "5", "6"})
    String availableModel;

    @Metadata
    @NotNull
    @ReleventConsistency(table = "TrafficParking", column = "parkingCode")
    String parkingCode;

    @Metadata
    @NotNull
    @ReleventConsistency(table = "TrafficParking", column = "parkingName")
    String parkingName;

    @Metadata
    @NotNull
    @Range(min = 0)
    Integer number;

    @Metadata
    @NotNull
    @Range(min = 0)
    Integer validNumber;

    @Metadata
    @NotNull
    @InInt({1, 2})
    Integer unPayBuyType;

    @Metadata
    String cardContent;

    @Metadata
    @NotNull
    @InInt({1, 2})
    Integer cardType;

    @Metadata
    @NotNull
    String useLimit;

    @Metadata
    @NotNull
    @InInt({0, 1})
    Integer delFlag;

    @Metadata
    @NotNull
    @InInt({0, 1, 2})
    Integer onlineType;

}
