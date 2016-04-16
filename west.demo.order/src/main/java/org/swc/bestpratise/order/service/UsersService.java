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
import org.swc.bestpratise.order.entity.Shop;
import org.swc.bestpratise.order.entity.Users;
import org.swc.bestpratise.order.repository.UsersDao;

import com.bucuoa.west.orm.extend.Page;

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
