package com.accp.biz.zyy;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.dao.zyy.IEvaluationServiceDao;
import com.accp.pojo.Evaluationservice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class EvaluationserviceBiz {
	private IEvaluationServiceDao dao;
	public PageInfo<Evaluationservice> qureyAllEvaluationService(Integer pageNum,Integer pageSize,Integer userid){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Evaluationservice>(dao.qureyAllEvaluationService(userid));
	}

}
