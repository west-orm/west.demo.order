package org.swc.bestpratise.order.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "product")
public class Product {

	@Column(name = "id")
	@Id()
	private int id; // id

	@Column(name = "name")
	private String name; // 名称

	@Column(name = "typex")
	private String typex; // 类型

	@Column(name = "price")
	private Double price; // 价格

	@Column(name = "buy_count")
	private int buyCount; // 购买次数

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

	public String getTypex() {
		return typex;
	}

	public void setTypex(String typex) {
		this.typex = typex;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}

}
