package com.accp.action.zyy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.biz.zyy.IntegralBiz;
import com.accp.pojo.Integral;
import com.accp.pojo.Integralrecord;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/c")
public class IntegralAction {
	@Autowired
private IntegralBiz biz;
	@GetMapping("zyy/queryAllIntegral")
	public String queryAllIntegral(Integer pageNum,Integer pageSize,Integer userid ,Model model){
		PageInfo<Integralrecord> pageInfo=biz.queryAllIntegral(pageNum, pageSize, userid);
		model.addAttribute("PAGE_INFO", pageInfo);
		System.out.println("aaaaaaaaaaaaa");
		System.out.println(pageInfo.getPageNum());
		return "zyy/wodejifen.html";
	}
	@PostMapping("zyy/insertintegralRecord")
	@ResponseBody
	public Map<String, String> insertintegralRecord(@RequestBody Integralrecord integ) {
		Map<String, String> rs = new HashMap<String, String>();
		Integer userid=integ.getUserid();
	if(biz.queryByqiandao(userid)==null) {
		Integer integralid=integ.getIntegralid();
		Integral num=biz.queryByIntegral(integralid);
		Integer num1=num.getIntegral();
		integ.setRecordinandout(num1);
	
		Integer num2=integ.getRecordinandout();
		biz.insertintegralRecord(integ);
		Integer count=biz.updateintegralRecord(num2, userid);
			rs.put("code", "200");
			rs.put("msg", "ok");
		
	}else {
		rs.put("code", "500");
		rs.put("msg", "no");
	}
		return rs;
	}
}
