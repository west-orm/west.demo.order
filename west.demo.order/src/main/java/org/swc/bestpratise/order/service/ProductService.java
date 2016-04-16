package org.swc.bestpratise.order.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.swc.bestpratise.order.entity.Activity;
import org.swc.bestpratise.order.entity.Product;
import org.swc.bestpratise.order.repository.ProductDao;

import com.bucuoa.west.orm.extend.Page;

@Service
public class ProductService  extends BaseService<Product,Long>{
	@Autowired
	private ProductDao dao;

	public ProductDao getDao() {
		return dao;
	}




}
