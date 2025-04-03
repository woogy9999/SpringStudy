package com.sist.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonsGoods {
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex) {
		System.out.println("======오류발생=====");
		ex.printStackTrace();
	}
}
