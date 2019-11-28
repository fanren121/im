package com.im.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.dao.InvitationDao;
import com.im.pojo.Invitation;

@Service
public class InvitationServiceImpl implements InvitationService {

	@Autowired
	private InvitationDao invitationDao;

	@Override
	public List<Invitation> find() {
		return invitationDao.find();
	}

	@Override
	public Invitation find(int id) {
		return invitationDao.findById(id);
	}

	@Override
	public boolean insert(Invitation invitation) {
		invitation.setCreatedate(new Date(System.currentTimeMillis()));
		return invitationDao.insert(invitation) > 0 ? true : false;
	}

	@Override
	public boolean delete(int[] ids) {
		return invitationDao.delete(ids) > 0 ? true : false;
	}

	@Override
	public boolean update(Invitation invitation) {
		return invitationDao.update(invitation) > 0 ? true : false;
	}

	@Override
	public List<Invitation> find(Integer page, Integer pageSize) {
		Integer num = pageSize*(page-1);
		return invitationDao.findByPage(num, pageSize);
	}

}
