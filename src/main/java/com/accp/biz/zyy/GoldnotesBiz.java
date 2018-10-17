package com.accp.biz.zyy;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.zyy.IGoldnotesDao;
import com.accp.pojo.Banktype;
import com.accp.pojo.Goldnotes;
import com.accp.pojo.Integralrecord;
import com.accp.pojo.Putforward;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class GoldnotesBiz {
	@Autowired
	private IGoldnotesDao dao;
	public PageInfo<Goldnotes> queryAllgoldnotes(Integer pageNum,Integer pageSize,Integer userid){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Goldnotes>(dao.queryAllgoldnotes(userid));
	}
	public int insertPutforward(Putforward putforward) {
		return dao.insertPutforward(putforward);
	}
	public List<Banktype> selectBankType(){
		return dao.selectBankType();
	}
	public int updateMoney(Integer userid,float money) {
		return dao.updateMoney(userid, money);
	}
}
