package com.farmerec.util;

/**
 * 正则表达式验证工具
 * @author Administrator
 *
 */
public class validateUtil {

	/**
	 * 手机号码验证
	 */
	public static final String VALIDATEPHONE="^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
	/**
	 * 邮箱验证
	 */
	public static final String VALIDATEEMAIL="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	/**
	 * 身份证验证
	 */
	public static final String VALIDATEIDCARD="^\\d{15}|\\d{18}$";
	/**
	 * 价钱验证
	 */
	public static final String VALIDATEMONEY="^([0-9]+|[0-9]{1,3}(,[0-9]{3})*)(.[0-9]{1,2})?$";
	/**
	 * 邮编验证
	 */
	public static final String VALIDATEPOSTCODE="[1-9]\\d{5}(?!\\d)";
	/**
	 * qq验证
	 */
	public static final String VALIDATEQQ="[1-9][0-9]{4,}";

	/**
	 * 密码验证
	 */
	public static final String VALIDATEPASSWORD="^[A-Za-z0-9]+$";

	/**
	 * 数字验证
	 */
	public static final String VALIDATENUMBER="^(0|[1-9][0-9]*)$";
}
