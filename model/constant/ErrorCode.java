package org.spring.model.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorCode {

    public static final String NOT_FOUND = "not_found";
    public static final String ALREADY_EXIST = "already_exist";
}
