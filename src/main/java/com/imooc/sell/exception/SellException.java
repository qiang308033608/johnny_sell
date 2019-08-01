package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnums;

public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnums resultEnums) {
        super(resultEnums.getMessage());

        this.code=resultEnums.getCode();

    }
}
