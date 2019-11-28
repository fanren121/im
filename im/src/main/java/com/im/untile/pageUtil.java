package com.im.untile;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.im.pojo.Invitation;
import com.im.pojo.PagePo;
import com.im.service.InvitationService;

public class pageUtil {
	
	@Autowired
	private InvitationService invitationService;
	
	public PagePo getPage(Integer page) {
		List<Invitation> list = new ArrayList<>();
		Integer pageSize = 2;
		list = invitationService.find(page,pageSize);
		int count = invitationService.find().size();
		int endPage = (int) Math.ceil((double)count/pageSize);
		PagePo pagePo = new PagePo(count,page,pageSize,endPage,list);
		return pagePo;
	}
}
