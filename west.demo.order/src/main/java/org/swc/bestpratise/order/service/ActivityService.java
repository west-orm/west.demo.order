package org.swc.bestpratise.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.swc.bestpratise.order.entity.Activity;
import org.swc.bestpratise.order.repository.ActivityDao;

@Service
public class ActivityService extends BaseService<Activity,Long>{
	@Autowired
	private ActivityDao dao;
	
	public ActivityDao getDao() {
		return dao;
	}


	

}
