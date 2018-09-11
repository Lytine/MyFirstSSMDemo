package org._233Latiao.Lytine.ssm.controller;

import org._233Latiao.Lytine.ssm.exception.DataNotFoundException;
import org._233Latiao.Lytine.ssm.exception.GlobalExceptionResolver;
import org._233Latiao.Lytine.ssm.service.IExceptionDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import util.ResultMap;

@RestController
@RequestMapping("/exception")
@GlobalExceptionResolver
public class ExceptionExampleController extends BaseController {
	
	@Autowired
	private IExceptionDemoService exceptionDemoServiceImpl;
	
	@GetMapping(value="/demo1")
	public ResultMap demo1() {
		try {
			exceptionDemoServiceImpl.demo();
		} catch (DataNotFoundException e) {
			e.printStackTrace();
			return ResultMap.fail(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.fail("由于未知错误，操作失败");
		}
		return ResultMap.success();
	}
	
	@GetMapping(value="/demo2")
	public ResultMap demo2() {
		exceptionDemoServiceImpl.demo();
		return ResultMap.success();
	}

	public void setExceptionDemoServiceImpl(IExceptionDemoService exceptionDemoServiceImpl) {
		this.exceptionDemoServiceImpl = exceptionDemoServiceImpl;
	}
	
	
}
