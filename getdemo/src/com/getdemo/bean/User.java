package com.getdemo.bean;

public class User {

	private String email; // 邮箱
	private String pwd; // 密码
	private String vercode; // 验证码
	private String downOK; // 是否可下载
	private String time; // 注册时间

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getVercode() {
		return vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}

	public String getDownOK() {
		return downOK;
	}

	public void setDownOK(String downOK) {
		this.downOK = downOK;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
