package com.accp.biz.zyy;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.zyy.IIntegralDao;
import com.accp.pojo.Integral;
import com.accp.pojo.Integralrecord;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class IntegralBiz {
	@Autowired
private IIntegralDao dao;
	/**
	 * 查询增加积分业务的增加积分数
	 * @return
	 */
public Integral queryByIntegral(Integer integralid) {
	return dao.queryByIntegral(integralid);
}
/**
 * 新增积分记录
 * @param integ
 * @return
 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int insertintegralRecord(Integralrecord integ) {
		return dao.insertintegralRecord(integ);
	}
	/**
	 * 查询个人积分
	 * @param pageNum
	 * @param pageSize
	 * @param userid
	 * @return
	 */
	public PageInfo<Integralrecord> queryAllIntegral(Integer pageNum,Integer pageSize,Integer userid){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Integralrecord>(dao.queryAllIntegral(userid));
	}
	/**
	 * 判断当天是否已经签到
	 * @return
	 */
	public Integralrecord queryByqiandao(Integer userid) {
		return dao.queryByqiandao(userid);	
	}
	/**
	 * 修改user表积分
	 * @param num
	 * @param userid
	 * @return
	 */
	public int updateintegralRecord(Integer num,Integer userid) {
		return dao.updateintegralRecord(num, userid);
	}
}
