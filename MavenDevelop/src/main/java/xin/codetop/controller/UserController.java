package xin.codetop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jfinal.kit.JsonKit;

import xin.codetop.mapper.UserMapper;
import xin.codetop.pojo.Order;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserMapper userMapper;

	@RequestMapping("/orders")
	public String listall(HttpServletRequest request,Model model) throws Exception{
		List<Order> orders = userMapper.getUserOrders(1); 
		model.addAttribute("orders", orders);
		return "user_orders";
	}
	
	@RequestMapping("/orders1")
	public String listall1(HttpServletRequest request,Model model) throws Exception{
		List<Order> orders = userMapper.getUserOrders(1); 
		model.addAttribute("orders", JsonKit.toJson(orders));
		return "userJson.json";
	}
	
	@RequestMapping("/orders2")
	public String listall2(HttpServletRequest request,Model model) throws Exception{
		List<Order> orders = userMapper.getUserOrders(1); 
		model.addAttribute("orders", orders);
		return "userXml.xml";
	}
}