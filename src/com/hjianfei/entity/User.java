package com.hjianfei.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	private int user_id;
	private String user_name;
	private String user_phone;
	private String user_password;
	private String user_email;
	private String user_sex;
	private String user_avatar;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_avatar() {
		return user_avatar;
	}
	public void setUser_avatar(String user_avatar) {
		this.user_avatar = user_avatar;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_phone=" + user_phone
				+ ", user_password=" + user_password + ", user_email=" + user_email + ", user_sex=" + user_sex
				+ ", user_avatar=" + user_avatar + "]";
	}
	
}
