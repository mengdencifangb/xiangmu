package com.accp.dao.zyy;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Orders;
import com.accp.pojo.Services;
import com.accp.vo.zyy.OrdersStateNumber;
import com.accp.vo.zyy.ordersServicesServiceTypeVo;



public interface IOrdersDao {
	//查看预定
		public List<Orders> queryMyYudin(@Param("usid") Integer usid);
		//查看我的所有订单
		public List<ordersServicesServiceTypeVo> queryAllMyOrder(@Param("usid")int usid,@Param("title")String title);
		//查看预定的数量
		public OrdersStateNumber queryordersStateNumber(@Param("usid")int usid);
		//取消服务
		
		public int updateOrderState(@Param("State")int State,@Param("oid")int oid);
}
