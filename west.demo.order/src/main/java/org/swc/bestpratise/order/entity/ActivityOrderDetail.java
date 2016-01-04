package org.swc.bestpratise.order.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "activity_order_detail")
public class ActivityOrderDetail {

	@Column(name = "id")
	@Id()
	private int id; // id

	@Column(name = "activity_id")
	private int activityId; // 活动

	@Column(name = "order_id")
	private int orderId; // 订单

	@Column(name = "user_id")
	private int userId; // 用户
	
	@Column(name = "user_name")
	private String userName; // 用户

	@Column(name = "nums")
	private int nums; // 数量

	@Column(name = "price")
	private Double price; // 价格

	@Column(name = "product_id")
	private int productId; // 商品编号

	@Column(name = "product")
	private String product; // 商品

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

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

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

}
