package org.swc.bestpratise.order.repository;

import org.springframework.stereotype.Repository;
import org.swc.bestpratise.order.entity.ActivityOrder;

import com.bucuoa.west.orm.extend.spring.SpringEntityDaoBase;
@Repository
public class ActivityOrderDao extends SpringEntityDaoBase<ActivityOrder, Long>   implements BaseDao<ActivityOrder, Long>{


}						 
								 
									