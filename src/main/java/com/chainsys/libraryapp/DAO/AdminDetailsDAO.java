package com.chainsys.libraryapp.dao;

import com.chainsys.libraryapp.LibaryModel.AdminDetails;

public interface AdminDetailsDAO {
	public void addNewAdmin(AdminDetails admindetails)throws Exception;
	public boolean userLogin(String mailId,String password)throws Exception;

}
