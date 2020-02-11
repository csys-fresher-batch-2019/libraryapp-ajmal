package com.chainsys.libaryapp.service;

import com.chainsys.libraryapp.Implementation.AdminDetailsDAOImp;
import com.chainsys.libraryapp.LibaryModel.AdminDetails;
import com.chainsys.libraryapp.dao.AdminDetailsDAO;

public class AdminDetailsService {
	private AdminDetailsDAO adminDetailsDAO=new AdminDetailsDAOImp();
	
	public void addNewAdmin(AdminDetails admindetails)throws Exception
	{
		adminDetailsDAO.addNewAdmin(admindetails);
	}
	public boolean userLogin(String mailId,String password)throws Exception{
		return adminDetailsDAO.userLogin(mailId, password);
	}
}
