package com.eureka.zuul.utils;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.eureka.zuul.exceptions.ArgumentInvalidException;

public class Utils {
    public static void assertArgumentNotEmptyOrNotNull(String field,
            String errMessage) {

        if (StringUtils.isBlank(field))
            throw new ArgumentInvalidException(errMessage);
    }

    public static void assertArgumentNotEmptyOrNotNull(Object object,
            String errMessage) {

        if (Objects.isNull(object))
            throw new ArgumentInvalidException(errMessage);
    }

}
