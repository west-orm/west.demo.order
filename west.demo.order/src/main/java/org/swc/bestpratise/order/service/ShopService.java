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
import org.swc.bestpratise.order.entity.Product;
import org.swc.bestpratise.order.entity.Shop;
import org.swc.bestpratise.order.repository.ShopDao;

import com.bucuoa.west.orm.extend.Page;

@Service
public class ShopService  extends BaseService<Shop,Long>{
	@Autowired
	private ShopDao dao;

	public ShopDao getDao() {
		return dao;
	}
	
	
}
