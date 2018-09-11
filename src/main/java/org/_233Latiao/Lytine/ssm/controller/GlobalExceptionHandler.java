package org._233Latiao.Lytine.ssm.controller;

import org._233Latiao.Lytine.ssm.exception.DataNotFoundException;
import org._233Latiao.Lytine.ssm.exception.GlobalExceptionResolver;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import util.ResultMap;

//@RestControllerAdvice(basePackages= {"org._233Latiao.Lytine.ssm.controller"})
@RestControllerAdvice(annotations= {GlobalExceptionResolver.class})
public class GlobalExceptionHandler {
	
	@ExceptionHandler({DataNotFoundException.class})
	public ResultMap dataNotFoundExceptionHandler(DataNotFoundException e) {
		e.printStackTrace();
		return ResultMap.fail(e.getMessage());
	}
	
	@ExceptionHandler({Exception.class})
	public ResultMap exceptionHandler(Exception e) {
		e.printStackTrace();
		return ResultMap.fail("由于未知错误，操作失败");
	}
	
}
