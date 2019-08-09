package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnums implements CodeEnums{
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"取消"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
