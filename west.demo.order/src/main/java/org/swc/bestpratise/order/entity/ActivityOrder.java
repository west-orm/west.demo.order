package org.swc.bestpratise.order.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "activity_order")
public class ActivityOrder {

	@Column(name = "id")
	@Id()
	private int id; // id

	@Column(name = "activity_id")
	private int activityId; // 活动

	@Column(name = "user_id")
	private int userId; // 用户

	@Column(name = "user_name")
	private String userName; // 用户名

	@Column(name = "tel")
	private String tel; // 电话

	@Column(name = "status")
	private int status; // 状态

	@Column(name = "nums")
	private int nums; // 数量

	@Column(name = "master_id")
	private int masterId; // 发起人

	@Column(name = "create_time")
	private Date createTime; // 时间

	@Column(name = "content")
	private String content; // 内容

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public int getMasterId() {
		return masterId;
	}

	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
