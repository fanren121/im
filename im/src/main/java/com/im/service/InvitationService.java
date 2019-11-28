package com.im.service;

import java.util.List;

import com.im.pojo.Invitation;

public interface InvitationService {
	public List<Invitation> find();
	
	public List<Invitation> find(Integer page,Integer pageSize);
	
	public Invitation find(int id);

	public boolean insert(Invitation invitation);

	public boolean delete(int[] ids);

	public boolean update(Invitation invitation);
}
