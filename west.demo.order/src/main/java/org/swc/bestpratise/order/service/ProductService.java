package org.swc.bestpratise.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.swc.bestpratise.order.entity.Product;
import org.swc.bestpratise.order.repository.ProductDao;

import com.bucuoa.west.orm.extend.BaseService;

@Service
public class ProductService  extends BaseService<Product,Long>{
	@Autowired
	private ProductDao dao;

	public ProductDao getDao() {
		return dao;
	}




}
