package com.bw.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.dao.UserDao;
import com.bw.pojo.User;

@Controller
public class UserController {
	@Autowired
	UserDao ud;
	
	@RequestMapping("login.do")
	@ResponseBody
	public boolean login(User user,HttpSession session){
		user = ud.login(user);
		System.out.println(user);
		if(user!=null) {
			session.setAttribute("user", user);
			return true;
			
		}
		return false;
	
		
	}
	@RequestMapping("list.do")
	public String list(Model model,User user) {
		user.setCount(ud.count());
		List<User> list = ud.list(user);
		model.addAttribute("list", list);
		return "list";
		
	}
	
	@RequestMapping("add.do")
	@ResponseBody
	public boolean add(User user) {
		try {
			ud.add(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}
	
	@RequestMapping("del.do")
	@ResponseBody
	public boolean del(int id) {
		try {
			ud.del(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}
	
	@RequestMapping("huixian.do")
	@ResponseBody
	public User huixian(int id) {
		return ud.huixian(id);
		
	}
	
	@RequestMapping("update.do")
	@ResponseBody
	public boolean update(User id) {
		try {
			ud.update(id);
			return true;
		} catch (Exception e) {
		}
		return false;
		
	}
}
