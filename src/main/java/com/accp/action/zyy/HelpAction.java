package com.accp.action.zyy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/c/zyy")
@Controller
public class HelpAction {
	@GetMapping("helpfuwujianding")
public String helpfuwujianding() {
	return "zyy/helpfuwujianding.html";
}
	@GetMapping("helpfuwuliucheng")
public String helpfuwuliucheng() {
	return "zyy/helpfuwuliucheng.html";
}
	@GetMapping("helpguanyujifen")
public String helpguanyujifen() {
	return "zyy/helpguanyujifen.html";
}
	@GetMapping("helpguanyujinbi")
public String helpguanyujinbi() {
	return "zyy/helpguanyujinbi.html";
}
	@GetMapping("helpguanyuluntan")
public String helpguanyuluntan() {
	return "zyy/helpguanyuluntan.html";
}
	@GetMapping("helpguanyuruzhu")
public String helpguanyuruzhu() {
	return "zyy/helpguanyuruzhu.html";
}
	@GetMapping("helpguanyutixian")
public String helpguanyutixian() {
	return "zyy/helpguanyutixian.html";
}
	
	@GetMapping("helpguanyutuikuan")
public String helpguanyutuikuan() {
	return "zyy/helpguanyutuikuan.html";
}
	@GetMapping("helpguanyuwuliu")
public String helpguanyuwuliu() {
	return "zyy/helpguanyuwuliu.html";
}
	@GetMapping("helpguanyuzhuce")
public String helpguanyuzhuce() {
	return "zyy/helpguanyuzhuce.html";
}
	@GetMapping("helpjiaoyixuzhi")
public String helpjiaoyixuzhi() {
	return "zyy/helpjiaoyixuzhi.html";
}
	@GetMapping("helpqianzhengzhiyin")
public String helpqianzhengzhiyin() {
	return "zyy/helpqianzhengzhiyin.html";
}
	@GetMapping("helpwenxintishi")
public String helpwenxintishi() {
	return "zyy/helpwenxintishi.html";
}

}
