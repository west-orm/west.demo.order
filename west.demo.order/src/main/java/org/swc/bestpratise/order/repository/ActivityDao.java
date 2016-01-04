package org.swc.bestpratise.order.repository;

import org.springframework.stereotype.Repository;
import org.swc.bestpratise.order.entity.Activity;

import com.bucuoa.west.orm.extend.spring.SpringEntityDaoBase;

@Repository
public class ActivityDao extends SpringEntityDaoBase<Activity, Long> {

}
