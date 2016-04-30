package org.swc.bestpratise.order.repository;

import org.springframework.stereotype.Repository;
import org.swc.bestpratise.order.entity.Product;

import com.bucuoa.west.orm.extend.BaseDao;
import com.bucuoa.west.orm.extend.spring.SpringEntityDaoBase;
@Repository
public class ProductDao extends SpringEntityDaoBase<Product, Long> implements BaseDao<Product, Long>{


}						 
								 
									