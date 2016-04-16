package org.swc.bestpratise.order.repository;

import org.springframework.stereotype.Repository;
import org.swc.bestpratise.order.entity.Shop;
import org.swc.bestpratise.order.entity.Users;

import com.bucuoa.west.orm.extend.spring.SpringEntityDaoBase;
@Repository
public class UsersDao extends SpringEntityDaoBase<Users, Long>  implements BaseDao<Users, Long>{


}						 
								 
									