package com.getdemo.email;

import java.sql.SQLException;

public class SendEmail {

	public void runSendEmail(String email, String url) throws SQLException {

		MailInfo mailInfo = new MailInfo();
		String subjectStirng = "GetDemo.com.cn 注册验证邮件";
		mailInfo.setMailServerHost("smtp.mxhichina.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUsername("notice@getdemo.com.cn‍");
		mailInfo.setPassword("QAZwsxedcrfv1234");
		mailInfo.setFromAddress("notice@getdemo.com.cn");

		mailInfo.setToAddress(email);
		mailInfo.setSubject(subjectStirng);

		StringBuffer demo = new StringBuffer();
		demo.append(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">")
				.append("<html>").append("<head>")
				.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")
				.append("<title>" + subjectStirng + "</title>").append("<style type=\"text/css\">")
				.append(".test{font-family:\"Microsoft Yahei\";font-size: 18px;}").append("</style>").append("</head>")
				.append("<body>").append("<span class=\"test\">" + subjectStirng + "<br /><br /></span>")
				.append("<span class=\"test\">尊敬的 GetDemo.com.cn 用户,您好：<br /><br /></span>")
				.append("<span class=\"test\"><a href=\"" + url
						+ "\" target=\"view_frame\">点击这里</a> &nbsp;&nbsp;&nbsp;&nbsp; 完成注册<br /><br /></span>")
				.append("<span class=\"test\">如果不能点击，清将下面的链接复制到浏览器<br /><br /></span>")
				.append("<span class=\"test\">" + url + "<br /><br /></span>").append("</body>").append("</html>");
		mailInfo.setContent(demo.toString());
		SimpleMail.sendHtmlMail(mailInfo);

	}
}