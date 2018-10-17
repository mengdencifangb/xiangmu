package com.accp.dao.zyy;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Banktype;
import com.accp.pojo.Goldnotes;
import com.accp.pojo.Putforward;

public interface IGoldnotesDao {
	/**
	 * 查询个人金币
	 * @return
	 */
public List<Goldnotes> queryAllgoldnotes(@Param("userid") Integer userid);
   /**
    * 新增提现记录
    * @param putforward
    * @return
    */
public int insertPutforward(@Param("putforward") Putforward putforward);
 /**
  * 查看银行类型
  * @return
  */
public List<Banktype> selectBankType();
/**
 * 提现成功减少金币
 * @param userid
 * @param money
 * @return
 */
public int updateMoney(@Param("userid") Integer userid,@Param("money") float money);
}
