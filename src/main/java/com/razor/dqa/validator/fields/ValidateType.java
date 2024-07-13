package com.razor.dqa.validator.fields;

public enum ValidateType {


    /**
     * 规范性：元数据
     */
    METADATA,

    /**
     * 规范性：业务规则-房产证件编号
     */
    HOUSE_NO,

    /**
     * 完整性：元素非空
     */
    ELEMENT_NOT_NULL,
    
    
  
    /**
     * 准确性：数据格式合规-字符串枚举
     */
    IN_STRING,

    /**
     * 准确性：数据格式合规-数值枚举
     */
    IN_INT,

    /**
     * 准确性：数据格式规格-数值取值范围
     */
    RANGE,

    /**
     * 准确性：数据格式规格-正则
     */
    REGEX,

    /**
     * 准确性：唯一性
     */
    UNIQUESS,


    /**
     * 一致性：关联数据一致性
     */
    RELEVENT_CONSISTENCY,


    /**
     * 时效性：时序性-晚于
     */
    AFTER,
    
    
    
    ;



}
