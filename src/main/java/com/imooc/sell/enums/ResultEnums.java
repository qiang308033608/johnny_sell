package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnums {

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    ;


    private Integer code;

    private String message;

    ResultEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
