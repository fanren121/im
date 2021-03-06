package com.im.controller;


import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.IntArraySerializer;
import com.im.pojo.Invitation;
import com.im.pojo.PagePo;
import com.im.service.InvitationService;

@Controller 
public class InvitationController {
		
		Logger log = Logger.getLogger(InvitationController.class);
		
		@Resource
		private InvitationService invitationService;
		
		@RequestMapping("/index")
		public String index(){
			System.err.println("index...");
			return "forward:/index.jsp";
		}
		@RequestMapping("/list")
		public String list(Model model,Integer page){
			log.debug("list..");
			List<Invitation> list = invitationService.find();
			System.out.println(list.size());
			return "list";
		}
		@RequestMapping("/add")
		public String add(){
			log.debug("add..");
			return "add";
		}
		@RequestMapping("/addSave")
		public String addSave(Invitation invitation){
			log.debug("Invitation.title"+invitation.getTitle());
			boolean flag = invitationService.insert(invitation);
			log.debug("flag:"+flag);
			return "redirect:list.action";
		}
		@RequestMapping("/update")
		public String update(int id,Model model){
			Invitation invitation = invitationService.find(id);
			model.addAttribute("invitation", invitation);
			return "update";
		}
		@RequestMapping("/updateSave")
		public String updateSave(Invitation invitation){
			invitationService.update(invitation);
			return "redirect:list.action";
					
		}
		@RequestMapping("/delete")
		public String delete(int[] ids){
			invitationService.delete(ids);
			return "redirect:list.action";
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
