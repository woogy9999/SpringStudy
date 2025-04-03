package com.sist.commons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 공통 예외처리 => Controller

@ControllerAdvice
public class CommonsRecipe {
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex) {
		System.out.println("========= 오류 발생 =======");
		ex.printStackTrace();
	}
}
