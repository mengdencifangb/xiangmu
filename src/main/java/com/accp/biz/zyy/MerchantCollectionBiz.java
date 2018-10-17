package com.accp.biz.zyy;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.zyy.IMerchantCollectionDao;
import com.accp.vo.zyy.MerchantCollectionVo;
import com.accp.vo.zyy.ServiceCollectionVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class MerchantCollectionBiz {
	@Autowired
	private IMerchantCollectionDao dao;
	//查询所有收藏的商家
	public PageInfo<MerchantCollectionVo> queryAllMerchantCollection(Integer pageNum,Integer pageSize,Integer userid,String merchantOrServiceByName){
	   PageHelper.startPage(pageNum,pageSize);
		return new PageInfo<MerchantCollectionVo>	(dao.queryAllMerchantCollection(userid, merchantOrServiceByName));
	}
	//查询所有收藏的服务
	public PageInfo <ServiceCollectionVo> queryAllServiceCollection(Integer pageNum,Integer pageSize,Integer userid,String servicetitle){
		 PageHelper.startPage(pageNum,pageSize);
		 return new PageInfo<ServiceCollectionVo>(dao.queryAllServiceCollection(userid, servicetitle));
	}
	public List<ServiceCollectionVo> queryAllType(Integer userid){
		return dao.queryAllType(userid);
	}
	public int deleteServiceCollection(@Param("sercolleid") Integer sercolleid) {
		return dao.deleteServiceCollection(sercolleid);
	}
	public List<MerchantCollectionVo> queryAllsjType(Integer userid){
		return dao.queryAllsjType(userid);
	}
	public int deleteMerchantCollection(@Param("collectid") Integer collectid) {
		return dao.deleteMerchantCollection(collectid);
		
	}
}
