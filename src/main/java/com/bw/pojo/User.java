package com.bw.pojo;

import com.bw.utils.PageUtils;

public class User extends PageUtils{
	int id;
	String name;
	String pwd;
	String sex;
	
	int sid;
	String school;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", sex=" + sex + ", sid=" + sid + ", school="
				+ school + ", getId()=" + getId() + ", getName()=" + getName() + ", getPwd()=" + getPwd()
				+ ", getSex()=" + getSex() + ", getSid()=" + getSid() + ", getSchool()=" + getSchool() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
