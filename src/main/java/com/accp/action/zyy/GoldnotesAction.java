package com.accp.action.zyy;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.biz.zyy.GoldnotesBiz;
import com.accp.pojo.Banktype;
import com.accp.pojo.Goldnotes;
import com.accp.pojo.Integralrecord;
import com.accp.pojo.Putforward;
import com.accp.pojo.User;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/c/zyy")
public class GoldnotesAction {
	@Autowired
private GoldnotesBiz biz;
	@GetMapping("queryAllgoldnotes")
	public String queryAllgoldnotes(Integer pageNum,Integer pageSize,Integer userid ,Model model){
		PageInfo<Goldnotes> pageInfo=biz.queryAllgoldnotes(pageNum, pageSize, userid);
		model.addAttribute("PAGE_INFO", pageInfo);
		System.out.println("干得好");
		System.out.println(pageInfo.getPageNum());
		return "zyy/wodejinbi.html";
	}
	@GetMapping("queryTixian")
	public String queryTixian(Model model) {
		List<Banktype> banktype=biz.selectBankType();
		model.addAttribute("banktype", banktype);
		return "zyy/wodetixian.html";
	}
	@PostMapping("insertPutforward")
	public String insertPutforward(@ModelAttribute Putforward putforward){
	    int userid=putforward.getUserid();
	    float money=putforward.getMoney();
		int count= biz.insertPutforward(putforward);
		if(count>0) {
			biz.updateMoney(userid, money);
			System.out.println("提交成功");
		}
		return "redirect:/c/zyy/queryUser?userid="+userid;
	}

}
