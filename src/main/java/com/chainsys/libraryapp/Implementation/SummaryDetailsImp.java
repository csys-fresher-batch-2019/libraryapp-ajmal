package com.chainsys.libraryapp.Implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import com.chainsys.libraryapp.DAO.SummaryDetailsDAO;
import com.chainsys.libraryapp.LibaryModel.StudentFineSummaryDetails;
import com.chainsys.libraryapp.LibaryModel.SummaryDetailsDueDate;
import com.chainsys.libraryapp.LibaryModel.SummaryDetailsStudentDetails;
import com.chainsys.libraryapp.Utile.ConnectionUtile;
import com.chainsys.libraryapp.exception.DbException;

public class SummaryDetailsImp implements SummaryDetailsDAO {


	public void addNewEntry(int studentId, int bookId) throws DbException {
		String sqll = "select * from details where book_id=" + bookId + " and std_id=" + studentId + " and status =0";
		try(Connection con=ConnectionUtile.getConnection(); Statement st = con.createStatement();ResultSet rs = st.executeQuery(sqll);) {
			int dBookId = 0;
			if (rs.next()) {
				dBookId = rs.getInt("book_id");
			}
			if (dBookId == bookId) {
				System.out.println("You have already taken this book, Try another");
			} else {
				String sql = "insert into details(book_id,std_id,book_count) values(?,?,book_count_sq.nextval)";
				System.out.println(sql);
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, bookId);
				stmt.setInt(2, studentId);
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to insert");
		}

	}

	public Integer calculateFineAmount(int studentId, int bookId) throws DbException {
		
		LocalDate returnedDate = LocalDate.now();
		Integer fineAmount = null;
		String sql = "select * from details where book_id=? and std_id=? and status=0";
		try(Connection con=ConnectionUtile.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);)
		{
		stmt.setInt(1, bookId);
		stmt.setInt(2, studentId);
		try(ResultSet rs = stmt.executeQuery();)
		{
		LocalDate dueDate = null;
		

		if (rs.next()) {
			dueDate = rs.getDate("due_date").toLocalDate();

		}

		if (returnedDate.isAfter(dueDate)) {
			int diffInDays = (int) ChronoUnit.DAYS.between(dueDate, returnedDate);
			fineAmount = diffInDays * 2;

		} else {
			//System.out.println("No Due Pending");
			fineAmount = 0;
		}
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new DbException("Unable to Calculate");
		}
		return fineAmount;
	}

	public ArrayList<SummaryDetailsDueDate> displayStudentDetailsForDueDate(int bookId) throws DbException {
		String sql = "select  d.std_id,s.std_name,s.std_dept,s.std_mob_no,d.book_id,b.book_name,d.issue_date,d.due_date from details d,books b ,student s where s.std_id=d.std_id and d.status=0 and b.book_id=d.book_id and d.book_id=?";
		ArrayList<SummaryDetailsDueDate> list = new ArrayList<SummaryDetailsDueDate>();
		try(Connection con=ConnectionUtile.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);)
		{
		stmt.setInt(1, bookId);
		try(ResultSet rs = stmt.executeQuery();)
		{
		
		while (rs.next()) {
			SummaryDetailsDueDate ob = new SummaryDetailsDueDate();
			ob.setStudentId(rs.getInt("std_id"));
			ob.setStudentName(rs.getString("std_name"));
			ob.setStudentDept(rs.getString("std_dept"));
			ob.setMobileNumber(rs.getLong("std_mob_no"));
			ob.setBookId(rs.getInt("book_id"));
			ob.setBookName(rs.getString("book_name"));
			ob.setIssueDate(rs.getDate("issue_date"));
			ob.setDueDate(rs.getDate("due_date"));
			list.add(ob);
		}
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new DbException("Unable to Display");
		}
		return list;
	}

	public int totalFineAmount() throws Exception {
		int total=0;
		String sql = "select sum(fine_amt) from details";
		try(Connection con=ConnectionUtile.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();)
		{
		if (rs.next()) {
			total = rs.getInt("sum(fine_amt)");
			
		}
		}

	catch(SQLException e)
		{
		e.printStackTrace();
		throw new DbException("Unable to calculate");
		}
		return total;

	}

	public ArrayList<SummaryDetailsStudentDetails> studentNotReturnedBook(int studentId) throws DbException {
		ArrayList<SummaryDetailsStudentDetails> list = new ArrayList<SummaryDetailsStudentDetails>();
		String sql = "select  s.std_name,b.book_name,b.book_id,d.issue_date,d.due_date from details d,books b ,student s where s.std_id=d.std_id and d.status=0 and b.book_id=d.book_id and d.std_id=?";
		try(Connection con=ConnectionUtile.getConnection();PreparedStatement stmt = con.prepareStatement(sql);)
		{
		stmt.setInt(1, studentId);
		try(ResultSet rs = stmt.executeQuery();)
		{
		
		while (rs.next()) {
			SummaryDetailsStudentDetails ob = new SummaryDetailsStudentDetails();
			ob.setBookId(rs.getInt("book_id"));
			ob.setBookName(rs.getString("book_name"));
			ob.setIssueDate(rs.getDate("issue_date"));
			ob.setDuedate(rs.getDate("due_date"));
			ob.setStudentName(rs.getString("std_name"));
			list.add(ob);
		}
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new DbException("Unable to display");
		}
		return list;
	}

	public void updateReturnRecord(int studentId, int bookId, Integer fineAmount) throws DbException, SQLException {
		
		if (fineAmount != 0) {
			String sql = "update details set fine_amt=? where book_id =? and std_id =? and status=0";
			try(Connection con=ConnectionUtile.getConnection();PreparedStatement stmt = con.prepareStatement(sql);)
			{
			stmt.setInt(1, fineAmount);
			stmt.setInt(2, bookId);
			stmt.setInt(3, studentId);
			stmt.executeUpdate();
			}
			System.out.println("Fine Updated");
			} 
			else {
			String sql = "update details set fine_amt=0 where book_id =? and std_id =? and status=0";
			try(Connection con=ConnectionUtile.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);)
			{
			stmt.setInt(1, bookId);
			stmt.setInt(2, studentId);
			stmt.executeUpdate();
			}
			System.out.println("Fine Updated");
		}
		String sql2 = "update details set status=1 , returned_date=sysdate where book_id =? and std_id =? and status=0";
		try(Connection con=ConnectionUtile.getConnection();PreparedStatement stmt2 = con.prepareStatement(sql2);)
		{
		stmt2.setInt(1, bookId);
		stmt2.setInt(2, studentId);
		stmt2.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new DbException("Unable to update");
		}
	}

	@Override
	public boolean bookTaken(int studentId, int bookId) throws DbException {
		boolean taken = false;

		String sql = "select * from details where book_id=? and std_id=? and status=0";
		System.out.println(sql);
		try(Connection con=ConnectionUtile.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setInt(1, bookId);
			stmt.setInt(2, studentId);

			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					taken = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to fetch book taken details");
		}

		return taken;
	}

	@Override
	public ArrayList<StudentFineSummaryDetails> totalFineAmountOfStudent(int studentId) throws DbException {
		String sql="select  s.std_name,b.book_name,b.book_id,b.book_cat,d.issue_date,d.due_date,d.fine_amt from details d,books b ,student s where s.std_id=d.std_id and d.status=0 and b.book_id=d.book_id and d.std_id=?";
		ArrayList<StudentFineSummaryDetails> list=new ArrayList<>();
		try(Connection con=ConnectionUtile.getConnection(); PreparedStatement stmt=con.prepareStatement(sql);)
		{
			stmt.setInt(1, studentId);
			int totalFineAmount=0;
			int fineAmount=0;
			LocalDate returnedDate = LocalDate.now();
			try(ResultSet rs=stmt.executeQuery();)
			{
				while(rs.next()) {
					StudentFineSummaryDetails ob=new StudentFineSummaryDetails();
					ob.setStudentName(rs.getString("std_name"));
					ob.setBookId(rs.getInt("book_id"));
					ob.setBookName(rs.getString("book_Name"));
					ob.setBookCategory(rs.getString("book_cat"));
					ob.setIssueDate(rs.getDate("issue_date"));
					Date date = rs.getDate("due_date");
					LocalDate d = date.toLocalDate();
					ob.setDueDate(date);
					
					if (returnedDate.isAfter(d)) {
						int diffInDays = (int) ChronoUnit.DAYS.between(d, returnedDate);
						fineAmount = diffInDays * 2;
						ob.setFineAmount(fineAmount);
						totalFineAmount=fineAmount+totalFineAmount;
					}
					else {
						ob.setFineAmount(0);
					}
					list.add(ob);
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new DbException("Unable to Calaculate");
		}
	
		return list;
	}

}
