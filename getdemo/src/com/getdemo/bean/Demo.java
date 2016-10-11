package com.getdemo.bean;

public class Demo {

	public static final int PAGE_SIZE = 9; // 每页记录数

	private String type; // 类型
	private String name; // 名称
	private String function; // 功能
	private String describe; // 描述
	private int downCount; // 下载量
	private String downName; // 下载名称
	private String updateTime; // 最后更新时间
	private String author; // 作者
	private String downOK; // 是否可下载
	private String time; // 是否可下载

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public int getDownCount() {
		return downCount;
	}

	public void setDownCount(int downCount) {
		this.downCount = downCount;
	}

	public String getDownName() {
		return downName;
	}

	public void setDownName(String downName) {
		this.downName = downName;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
