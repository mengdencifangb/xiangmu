package com.accp.dao.zyy;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Integral;
import com.accp.pojo.Integralrecord;


public interface IIntegralDao {
	/**
	 * 查询增加积分业务的增加积分数
	 * @return
	 */

public Integral queryByIntegral(@Param("integralid") Integer integralid) ;
/**
 * 查询个人积分记录
 * @return
 */
public List<Integralrecord> queryAllIntegral(@Param("userid") Integer userid);
/**
 * 新增积分记录
 * @param integ
 * @return
 */
public int insertintegralRecord(@Param("integ") Integralrecord integ);
/**
 * 判断当天是否已经签到
 * @return
 */
public Integralrecord queryByqiandao(Integer userid) ;
/**
 * 修改用户表
 * @param num
 * @return
 */
public int updateintegralRecord(@Param("num") Integer num,@Param("userid") Integer userid);
}
