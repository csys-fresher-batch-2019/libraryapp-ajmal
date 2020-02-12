package com.chainsys.libraryapp.dao;

import com.chainsys.libraryapp.LibaryModel.AdminDetails;
import com.chainsys.libraryapp.exception.DbException;

public interface AdminDetailsDAO {
	public void addNewAdmin(AdminDetails admindetails)throws DbException;
	public boolean userLogin(String mailId,String password)throws DbException;

}
