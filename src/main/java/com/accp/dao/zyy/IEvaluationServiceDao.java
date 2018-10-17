package com.accp.dao.zyy;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Evaluationservice;

public interface IEvaluationServiceDao {
	/**
	 * 查询所有的评价表
	 * @param userid
	 * @return
	 */
public List<Evaluationservice> qureyAllEvaluationService(@Param("userid") Integer userid);
}
