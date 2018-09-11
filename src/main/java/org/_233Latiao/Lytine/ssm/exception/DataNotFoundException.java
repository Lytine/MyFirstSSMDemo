package org._233Latiao.Lytine.ssm.exception;

/**
 * 数据未找到异常
 * @author Latiao
 *
 */
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		super(message);
	}
}
