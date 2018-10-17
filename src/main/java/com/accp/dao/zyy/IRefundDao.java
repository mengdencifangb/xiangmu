package com.accp.dao.zyy;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Refund;

public interface IRefundDao {
	/**
	 * 查询所有退款记录
	 * @param userid
	 * @return
	 */
public List<Refund> queryAllRefund(@Param("userid") Integer userid);
}
