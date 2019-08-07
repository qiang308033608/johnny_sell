package com.imooc.sell.VO;

import lombok.Data;

import java.io.Serializable;


/*
* Http返回的最外层对象
* */
@Data
public class ResultVO<T> implements Serializable {


    /** 错误码.*/
    private Integer code;

    /** 提示信息.*/
    private String msg;

    /** 具体内容.*/
    private T date;
}
