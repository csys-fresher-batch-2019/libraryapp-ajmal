package com.chainsys.libraryapp.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.libraryapp.LibaryModel.StudentDetails;
import com.chainsys.libraryapp.Util.ConnectionUtil;
import com.chainsys.libraryapp.dao.StudentDetailsDAO;
import com.chainsys.libraryapp.exception.DbException;

public class StudentDetailsDAOImp implements StudentDetailsDAO {

	public void addStudentDetails(StudentDetails studentdetails) throws DbException {
		String sql = "insert into student(std_name,std_dept,std_dob,std_mail_id,std_mob_no,joining_yr,std_id) values(?,?,?,?,?,?,std_seq.nextval)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, studentdetails.getStudentName());
			stmt.setString(2, studentdetails.getStudentDepatment());
			stmt.setDate(3, studentdetails.getDateOfBirth());
			stmt.setString(4, studentdetails.getStudentMailId());
			stmt.setLong(5, studentdetails.getMobileNumber());
			stmt.setInt(6, studentdetails.getYearOfJoin());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to add Student");
		}
	}

	public StudentDetails displayStudentDetail(int studentId) throws DbException {
		StudentDetails ob = null;
		String sql = "select * from student where std_id=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setInt(1, studentId);
			try (ResultSet rs = stmt.executeQuery();) {

				if (rs.next()) {
					ob = new StudentDetails();
					ob.setStudentId(rs.getInt("std_id"));
					ob.setStudentName(rs.getString("std_name"));
					ob.setStudentDepatment(rs.getString("std_dept"));
					ob.setDateOfBirth(rs.getDate("std_dob"));
					ob.setStudentMailId(rs.getString("std_mail_id"));
					ob.setMobileNumber(rs.getLong("std_mob_no"));
					ob.setYearOfJoin(rs.getInt("joining_yr"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Unble to display a student record");
		}
		return ob;
	}

	public ArrayList<StudentDetails> displayAllStudents() throws DbException {
		ArrayList<StudentDetails> list = new ArrayList<StudentDetails>();
		String sql = "select * from student";
		try (Connection con = ConnectionUtil.getConnection();PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();)
		{
		
		while (rs.next()) {
			StudentDetails obj = new StudentDetails();
			obj.setStudentId(rs.getInt("std_id"));
			obj.setStudentName(rs.getString("std_name"));
			obj.setStudentDepatment(rs.getString("std_dept"));
			obj.setDateOfBirth(rs.getDate("std_dob"));
			obj.setStudentMailId(rs.getString("std_mail_id"));
			obj.setMobileNumber(rs.getLong("std_mob_no"));
			obj.setYearOfJoin(rs.getInt("joining_yr"));
			list.add(obj);

		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new DbException("Unable to Disaplay");
		}
		return list;
	}

}
