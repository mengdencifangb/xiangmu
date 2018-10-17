package com.accp.dao.zyy;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.vo.zyy.MerchantCollectionVo;
import com.accp.vo.zyy.ServiceCollectionVo;

public interface IMerchantCollectionDao {
	/**
	 * 查询所有收藏的商家
	 * @param userid
	 * @param collecttype
	 * @return
	 */
public List<MerchantCollectionVo> queryAllMerchantCollection(@Param("userid") Integer userid,@Param("merchantorservicebyname") String merchantorservicebyname);
/**
 * 查询所有收藏的服务
 * @param userid
 * @return
 */
public List <ServiceCollectionVo> queryAllServiceCollection(@Param("userid") Integer userid,@Param("servicetitle") String servicetitle);
/**
 * 查询收藏的类别
 * @param userid
 * @return
 */
public List<ServiceCollectionVo> queryAllType(@Param("userid") Integer userid);
/**
 * 删除收藏的服务
 * @param sercolleid
 * @return
 */
public int deleteServiceCollection(@Param("sercolleid") Integer sercolleid);
/**
 * 查询收藏商家的类别
 * @param userid
 * @return
 */
public List<MerchantCollectionVo> queryAllsjType(@Param("userid") Integer userid);
/**
 * 删除收藏的商家
 * @param sercolleid
 * @return
 */
public int deleteMerchantCollection(@Param("collectid") Integer collectid);
}
