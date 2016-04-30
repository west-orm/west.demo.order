package org.swc.bestpratise.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.swc.bestpratise.order.entity.Users;
import org.swc.bestpratise.order.repository.UsersDao;

import com.bucuoa.west.orm.extend.BaseService;

@Service
public class UsersService extends BaseService<Users,Long>{
	@Autowired
	private UsersDao dao;

	public UsersDao getDao() {
		return dao;
	}

	public Users findEntityBy(String username,String password) throws Exception {
		return dao.findEntityBy(new String[]{"user_name","password"}, new String[]{"'"+username+"'","'"+password+"'"});
	}



}
