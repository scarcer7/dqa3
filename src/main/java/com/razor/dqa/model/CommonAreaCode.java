package com.razor.dqa.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class CommonAreaCode implements Serializable {
    
    String parentCode;

    String code;

    String address;

    Integer level;

    String addressDetail;
}
