package com.accp.dao.zyy;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.User;
import com.accp.vo.zyy.UserVo;



public interface IUserDao {
	/**
	 * 登录
	 * @param userEmail           邮箱
	 * @param userPwd             密码
	 * @return
	 */
public UserVo Loggin(@Param("userEmail") String userEmail,@Param("userPwd") String userPwd);
/**
 * 查询用户信息
 * @param userid
 * @return
 */
public UserVo queryUser(@Param("userid") Integer userid);

}
