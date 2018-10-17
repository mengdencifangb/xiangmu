package com.accp.biz.zyy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.zyy.IOrdersDao;
import com.accp.pojo.Orders;
import com.accp.pojo.Services;
import com.accp.vo.zyy.OrdersStateNumber;
import com.accp.vo.zyy.ServiceCollectionVo;
import com.accp.vo.zyy.ordersServicesServiceTypeVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class OrdersBiz {
	@Autowired
private IOrdersDao dao;
public List<Orders> findMyServiceByusid(Integer usid) {
	return dao.queryMyYudin(usid);
}

public PageInfo<ordersServicesServiceTypeVo> findAllMyOrder(int usid,String title,int num,int size){
	PageHelper.startPage(num, size);
	return new PageInfo<ordersServicesServiceTypeVo>(dao.queryAllMyOrder(usid,title));
}

public OrdersStateNumber findOrdersStateNumber(int usid) {
	return dao.queryordersStateNumber(usid);
}

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
public int updateMyOrderState(int state,int oid) {
	int count = dao.updateOrderState(state, oid);
	return count;
}
}
