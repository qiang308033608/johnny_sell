package com.imooc.sell.Util;

import com.imooc.sell.enums.CodeEnums;

public class EnumsUtil {

    public static <T extends CodeEnums>T getByCode(Integer code, Class<T> enumsClass){
        for(T each : enumsClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
