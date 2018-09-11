package org._233Latiao.Lytine.ssm.service.impl;

import org._233Latiao.Lytine.ssm.exception.DataNotFoundException;
import org._233Latiao.Lytine.ssm.service.IExceptionDemoService;
import org.springframework.stereotype.Service;

@Service
public class ExceptionDemoServiceImpl implements IExceptionDemoService{

	@Override
	public void demo() {
		boolean hasError = true;
		if(hasError) {
			throw new DataNotFoundException("密码不正确");
		}
		try {
			System.out.println("访问数据库...");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataNotFoundException("记录不存在");
		}
		
	}

}
