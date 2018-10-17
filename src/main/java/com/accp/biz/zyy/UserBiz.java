package com.accp.biz.zyy;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.zyy.IUserDao;
import com.accp.pojo.User;
import com.accp.vo.zyy.UserVo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class UserBiz {
	@Autowired
private IUserDao dao;
	/**
	 * 登录
	 * @param userEmail
	 * @param userPwd
	 * @return
	 */
	public UserVo Loggin(String userEmail,String userPwd) {
		return dao.Loggin(userEmail, userPwd);
	}
	public UserVo queryUser(Integer userid) {
		return dao.queryUser(userid);
	}
}
