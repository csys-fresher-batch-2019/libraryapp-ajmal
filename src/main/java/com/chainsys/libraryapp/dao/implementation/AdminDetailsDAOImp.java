package com.chainsys.libraryapp.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.libraryapp.LibaryModel.AdminDetails;
import com.chainsys.libraryapp.util.Connectionutil;
import com.chainsys.libraryapp.dao.AdminDetailsDAO;
import com.chainsys.libraryapp.exception.DbException;

public class AdminDetailsDAOImp implements AdminDetailsDAO {

	public void addNewAdmin(AdminDetails admindetails) throws DbException {
		String sql = "insert into admin(admin_name,admin_dob,admin_mail_id,admin_mob_no,admin_password,admin_gender,admin_id) values (?,?,?,?,?,?,admin_id_seq.nextval)";
		try (Connection con = Connectionutil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, admindetails.getAdminName());
			stmt.setDate(2, Date.valueOf(admindetails.getAdminDOB()));
			stmt.setString(3, admindetails.getAdmilMailId());
			stmt.setLong(4, admindetails.getAdminMobileNo());
			stmt.setString(5, admindetails.getAdminPassword());
			stmt.setString(6, admindetails.getAdminGender());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to Add New Admin");
		}
	}

	public boolean userLogin(String mailId, String password) throws DbException {
		String sql = "select * from admin where admin_mail_id=?";
		boolean valuse = false;
		try (Connection con = Connectionutil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, mailId);
			try (ResultSet rs = stmt.executeQuery();) {
				String password1 = null;
				while (rs.next()) {
					password1 = rs.getString("admin_password");
				}
				if (password1.contentEquals(password)) {
					valuse=true;
				} 
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to login");
		}
		return valuse;
	}

}