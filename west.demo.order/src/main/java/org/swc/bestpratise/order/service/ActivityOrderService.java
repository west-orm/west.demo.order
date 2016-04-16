package org.swc.bestpratise.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.swc.bestpratise.order.entity.ActivityOrder;
import org.swc.bestpratise.order.repository.ActivityOrderDao;
import org.swc.bestpratise.order.repository.BaseDao;

@Service
public class ActivityOrderService extends BaseService<ActivityOrder,Long>{
	@Autowired
	private ActivityOrderDao dao;

	public ActivityOrderDao getDao() {
		return dao;
	}

	


}
