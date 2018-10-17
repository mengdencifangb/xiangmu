package com.accp.action.zyy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.biz.zyy.MerchantCollectionBiz;
import com.accp.pojo.Integral;
import com.accp.pojo.Integralrecord;
import com.accp.vo.zyy.MerchantCollectionVo;
import com.accp.vo.zyy.ServiceCollectionVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/c/zyy")
public class MerchantCollectionAction {
	@Autowired
private MerchantCollectionBiz biz;
	@GetMapping("queryAllMerchantCollection")
public String queryAllMerchantCollection(Integer pageNum,Integer pageSize,Integer userid,String merchantOrServiceByName,Model model) {
		if(merchantOrServiceByName==null||merchantOrServiceByName=="") {
			merchantOrServiceByName=null;
		}
		PageInfo<MerchantCollectionVo> pageInfo=biz.queryAllMerchantCollection(pageNum, pageSize, userid, merchantOrServiceByName);
		List<MerchantCollectionVo> listType=biz.queryAllsjType(userid);
		model.addAttribute("listType", listType);
		model.addAttribute("PAGE_INFO", pageInfo);
		return "zyy/wodeshoucang.html";
	}
	@GetMapping("queryAllServiceCollection")
public String queryAllServiceCollection(Integer pageNum,Integer pageSize,Integer userid,String servicetitle,Model model) {
		if(servicetitle==null||servicetitle=="") {
			servicetitle=null;
		}
		PageInfo<ServiceCollectionVo> pageInfo=biz.queryAllServiceCollection(pageNum, pageSize, userid, servicetitle);
		List<ServiceCollectionVo> listType=biz.queryAllType(userid);
		model.addAttribute("listType", listType);
	model.addAttribute("PAGE_INFO", pageInfo);
	System.out.println(pageInfo.getNextPage());
		return "zyy/fuwushoucang.html";
	}

	@GetMapping("deleteServiceCollection")
	public String deleteServiceCollection(Integer sercolleid,Integer userid) {
	Integer  count=biz.deleteServiceCollection(sercolleid);
	return "redirect:/c/zyy/queryAllServiceCollection?userid="+userid+"&pageNum=1&pageSize=10";

	}
	@GetMapping("deleteMerchantCollection")
	public String deleteMerchantCollection(Integer collectid,Integer userid) {
	Integer  count=biz.deleteMerchantCollection(collectid);
	System.out.println(count);
	return "redirect:/c/zyy/queryAllMerchantCollection?userid="+userid+"&pageNum=1&pageSize=10";

	}
}
