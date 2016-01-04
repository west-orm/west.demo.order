package org.swc.bestpratise.order.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users")
public class Users {

	@Column(name = "id")
	@Id()
	private int id; // 编号

	@Column(name = "real_name")
	private String realName; // 真实姓名

	@Column(name = "user_name")
	private String userName; // 用户名

	@Column(name = "email")
	private String email; // email

	@Column(name = "password")
	private String password; // 密码

	@Column(name = "mobile")
	private String mobile; // 手机

	@Column(name = "sex")
	private String sex; // 性别

	@Column(name = "city_id")
	private int cityId; // 城市

	@Column(name = "area_id")
	private int areaId; // 的确

	@Column(name = "reg_date")
	private Date regDate; // 注册日期

	@Column(name = "last_login_time")
	private Date lastLoginTime; // 上次登陆时间

	@Column(name = "status")
	private int status; // 状态

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
