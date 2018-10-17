package com.accp.action.zyy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.zyy.OrdersBiz;
import com.accp.biz.zyy.UserBiz;
import com.accp.pojo.Orders;
import com.accp.pojo.Services;
import com.accp.pojo.User;
import com.accp.vo.zyy.UserVo;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/c/zyy")
public class UserAction {
	@Autowired
private UserBiz biz;
	@Autowired
	private OrdersBiz bizz;
@GetMapping("Loggin")
public String queryLoggin(String useremail,String userpwd,HttpSession session,Model model) {
	UserVo us= biz.Loggin(useremail, userpwd);
	if(us!=null) {
		session.setAttribute("user", us);
		model.addAttribute("users", us);
		System.out.println(us.getUserid());
		List<Orders> listservice = bizz.findMyServiceByusid(us.getUserid());
		System.out.println(listservice);
		model.addAttribute("services",listservice);
	
		return "zyy/memberCenter.html";                                       //直接转发了
	}else {
		return "redirect:/zyy/denglu.html";                   //重定向
	}
}
@GetMapping("queryUser")
public String queryUser(Integer userid,Model model) {
	UserVo user= biz.queryUser(userid);
	if(user!=null) {
	//	session.setAttribute("user", user);
		model.addAttribute("users", user);
		List<Orders> listservice = bizz.findMyServiceByusid(user.getUserid());
		System.out.println(listservice);
		model.addAttribute("services",listservice);
		return "zyy/memberCenter.html";                                       //直接转发了
	}else {
		return "zyy/memberCenter.html";                   //重定向
	}
}
@GetMapping("tiao")
public String tiao() {
	return "zyy/memberCenter.html"; 
}
}
