package com.jojoldu.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)      // 이 어노테이션이 생성될 수 있는 위치를 지정
@Retention(RetentionPolicy.RUNTIME) // 어노테이션의 라이프사이클 정의
public @interface LoginUser {       // LoginUser 어노테이션 생성
}