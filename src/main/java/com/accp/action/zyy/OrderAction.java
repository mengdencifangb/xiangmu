package com.accp.action.zyy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.biz.zyy.OrdersBiz;
import com.accp.pojo.Login;
import com.accp.pojo.Services;
import com.accp.vo.zyy.OrdersStateNumber;
import com.accp.vo.zyy.ordersServicesServiceTypeVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/c/zyy")
public class OrderAction {
	@Autowired
private OrdersBiz biz;

/*@GetMapping("Gerenzx")
public String Gerenzx(HttpSession session,Model model) {
	Login lo = (Login) session.getAttribute("USER");
	List<Services> listservice = biz.findMyServiceByusid(lo.getUserid());
	model.addAttribute("services",listservice);
	
	return "DJJ/memberCenter";
}*/
@GetMapping("getAllMyOrders")
public String getAllMyOrders(int num,int size,String title,Integer userid,Model model) {
/*	Login lo = (Login) session.getAttribute("USER");*/
	if(title==null||title=="") {
		title=null;
	}
	System.out.println("标题"+title);
	System.out.println("id"+userid);
	System.out.println("num"+num);
	System.out.println("size"+size);
	PageInfo<ordersServicesServiceTypeVo> ordersvo = biz.findAllMyOrder(userid,title,num,size);
	System.out.println(ordersvo);
	OrdersStateNumber ordersStateNumber = biz.findOrdersStateNumber(userid);
	model.addAttribute("ordersvo",ordersvo);
	model.addAttribute("orderstate",ordersStateNumber);
	return "zyy/wodeyuding";
	
}


@ResponseBody
@RequestMapping(value="updateMyOrderState",method=RequestMethod.POST)
public Map<String ,Object> updateMyOrderState(int state,int oid){
	Map<String,Object> message=new HashMap<String,Object>();
	int count = biz.updateMyOrderState(state, oid);
	if(count>0) {
		message.put("code", "200");
		message.put("msg", "取消服务成功");
	}else {
		message.put("code", "500");
		message.put("msg", "取消服务失败");
	}
	
	return message;
	
}

}
