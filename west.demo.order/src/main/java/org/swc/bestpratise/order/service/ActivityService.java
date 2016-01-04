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
import org.swc.bestpratise.order.entity.Activity;
import org.swc.bestpratise.order.repository.ActivityDao;

import com.bucuoa.west.orm.extend.Page;

@Service
public class ActivityService {
	@Autowired
	private ActivityDao dao;
	@Transactional
	public Object saveEntity(Activity entity) throws Exception {
		 long start = System.currentTimeMillis();
		 Object saveEntity = dao.saveEntity(entity);
		 long end = System.currentTimeMillis();
		 System.out.println("写入耗时："+(end-start));
		 return saveEntity;
	}
	
	public Activity save(Activity entity) throws Exception {
		 Object id = dao.saveEntity(entity);
		 entity.setId(Integer.parseInt(id+""));
		 return entity;
	}

	@Transactional
	public void update(Activity entity) throws Exception {
		dao.updateEntity(entity);
	}

	public Activity findEntityById(Long id) throws Exception {
		return dao.findEntityById(id);
	}
	
	public Activity findEntityByUUID(String uuid) throws Exception {
		return dao.findEntityBy("uuid", "'"+uuid+"'");
	}

	public boolean deleteEntityById(Long id) throws Exception {
		return dao.deleteEntityById(id);
	}
	
	public int getEntityCount(String[] keyName, String[] operate,
			Object[] keyValue, Object... ext) throws Exception {
		return dao.getEntityCount(keyName, operate, keyValue, ext);
	}

	public List<Activity> findEntityList(String[] keyName,
			String[] operate, Object[] keyValue,String[] orderby,
			String[] pattern, int pageSize, int pageNo)
			throws Exception {
		return dao.findEntityList(keyName, operate, keyValue,orderby,pattern, pageSize, pageNo);
	}
	
	public List<Activity> findEntityList(String[] keyName,
			String[] operate, Object[] keyValue, int pageSize, int pageNo)
			throws Exception {
		return dao.findEntityList(keyName, operate, keyValue, pageSize, pageNo);
	}

	public List<Activity> myEntityList(String userId) throws Exception {
		return dao.findEntityList(new String[] { "creater_id" },
				new String[] { "=" }, new Object[] { "'"+userId+"' " });
	}

	@Transactional(readOnly = true)
	public Page getEntityPage(ServletRequest request) throws Exception {
		// filters_like_name filters_equals_categoryName
		int pageNO = 0;
		int pageSize = 30;
//		Map request = beat.getRequest();
		Map map = request.getParameterMap();

		Iterator<String> iter = map.keySet().iterator();

		List paralist = new ArrayList();
		while (iter.hasNext()) {

			String key = iter.next();
			String value = (String) request.getParameter(key);

			if (key.startsWith("filters")) {
				String tt[] = key.split("-");
				if (!"".equals(value)) {
					paralist.add(tt[2] + "-" + tt[1] + "-" + value);
				}
				request.setAttribute(tt[2], value);
			}

			if (key.equalsIgnoreCase("pageNO")) {
				try {
					pageNO = Integer.parseInt(value);
				} catch (Exception e) {
					// e.printStackTrace();
					pageNO = 1;
				}
			}
			
			if (key.equalsIgnoreCase("pageSize")) {
				try {
					pageSize = Integer.parseInt(value);
				} catch (Exception e) {
					// e.printStackTrace();
					pageSize = 30;
				}
			}
		}

		if (pageNO < 1) {
			pageNO = 1;
		}

		String names[] = new String[paralist.size()];// {"name","categoryName"};
		String opt[] = new String[paralist.size()]; // "like","like"
		Object[] params = new Object[paralist.size()];// "%"+name+"%","%"+categoryName+"%"

		for (int i = 0; i < paralist.size(); i++) {
			String tkl = (String) paralist.get(i);

			String name = tkl.split("-")[0];
			String value = tkl.split("-")[2];
			String optx = tkl.split("-")[1];
			if (!value.equals("")) {
				names[i] = name;
				if (optx.equals("equals")) {
					opt[i] = "=";
				} else {
					opt[i] = optx;
				}

				if (optx.equals("like")) {
					params[i] = "%" + value + "%";
				} else {
					params[i] = value;
				}

			}
		}

		int count = dao.getEntityCount(names, opt, params, null);
		List<Activity> data = dao.findEntityList(names, opt, params, pageSize, pageNO);

		Page page = new Page();
		page.setPageSize(pageSize);
		page.setPageNo(pageNO);
		page.setTotalCount(count);
		page.setData(data);

		return page;
	}

	@Transactional(readOnly = true)
	public Page getAllEntityPage(HttpServletRequest request) throws Exception {
		String pageNOStr = getReqValByParam(request, "pageNO");

		int pageNO = 0;
		if (!"".equals(pageNOStr)) {
			pageNO = Integer.parseInt(pageNOStr);
		}
		if (pageNO < 1) {
			pageNO = 1;
		}

		int count = dao.getEntityCount(new String[] {}, new String[] {},
				new Object[] {}, null);
		List<Activity> data = dao.findEntityList(new String[] {},
				new String[] {}, new Object[] {}, 10, pageNO);

		Page page = new Page();
		page.setPageSize(10);
		page.setPageNo(pageNO);
		page.setTotalCount(count);
		page.setData(data);

		return page;
	}

	protected String getReqValByParam(HttpServletRequest request, String param) {
		String value = request.getParameter(param);
		return (value == null) ? "" : value.trim();
	}

}
