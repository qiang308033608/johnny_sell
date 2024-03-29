package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnums implements CodeEnums{
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),

    ;

    private Integer code;

    private String message;

    PayStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
