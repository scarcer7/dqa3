package com.razor.dqa.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class RegisterUserInfo implements Serializable {

    Long id;

    String userId;

    String name;
}
