package TableBookSummary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import Libary3.SummaryDetailsDueDate;
import Libary3.SummaryDetailsStudentDetails;

public class SummaryDetailsImp implements SummaryDetailsDAO{
	public static Connection getConnection() throws Exception {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			return connection;
		
	}

	public void addNewEntry(int studentId, int bookId) throws Exception {
		Connection con =getConnection();
		String sqll="select * from details where book_id="+bookId+" and std_id="+studentId+" and status =0";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sqll);
		int dBookId = 0;
		if(rs.next())
		{
			  dBookId = rs.getInt("book_id");
		}	
		if(dBookId==bookId)
		{
			System.out.println("You have already taken this book, Try another");
		}
		else
		{		
		String sql="insert into details(book_id,std_id,book_count) values(?,?,book_count_sq.nextval)";
		System.out.println(sql);
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, bookId);
		stmt.setInt(2, studentId);
		int row=stmt.executeUpdate();
		System.out.println(row);
		}	
		con.close();
		
	}


	public int calculateFineAmount(int studentId, int bookId) throws Exception {
		Connection con=getConnection();
		LocalDate returnedDate=LocalDate.now();
		//Date date = Date.valueOf(returnedDate);
		String sql= "select * from details where book_id=? and std_id=? and status=0";
		System.out.println(sql);
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, bookId);
		stmt.setInt(2, studentId);
		ResultSet rs=stmt.executeQuery();
		LocalDate dueDate=null;
		int fineAmount=0;
		int diffInDays=0;
		if(rs.next())
		{
			 dueDate=rs.getDate("due_date").toLocalDate();
		}
		if(returnedDate.isAfter(dueDate))
		{
			 diffInDays = (int) ChronoUnit.DAYS.between(dueDate, returnedDate );
			 fineAmount=diffInDays*2;
			 System.out.println("FineAmount ="+fineAmount);
		}
		else
		{
			System.out.println("No Due Pending");
		}
		return fineAmount;
	}
	
	
	public void updateReturnRecord(int studentId, int bookId) throws Exception {
		Connection con=getConnection();
		LocalDate returnedDate=LocalDate.now();
		String sql= "select * from details where book_id=? and std_id=? and status=0";
		System.out.println(sql);
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, bookId);
		stmt.setInt(2, studentId);
		ResultSet rs=stmt.executeQuery();
		LocalDate dueDate=null;
		int fineAmount=0;
		int diffInDays=0;
		int a=1;
		if(rs.next())
		{
			 dueDate=rs.getDate("due_date").toLocalDate();
			 int status=rs.getInt("status");
			 a=status;
		}
		if(a==0)
		{
		if(returnedDate.isAfter(dueDate))
		{
			 diffInDays = (int) ChronoUnit.DAYS.between(dueDate, returnedDate );
			 fineAmount=diffInDays*2;
			 System.out.println("FineAmount ="+fineAmount);
		}
		else
		{
			System.out.println("No Due Pending");
		}
		System.out.println("do uou want to coyinue:(Y/N)- ");
		Scanner sc=new Scanner(System.in);
		String az=sc.next();
		sc.close();
		if(az.equalsIgnoreCase("Y"))
			{

		if(a==0)
		{
			String sql1="update details set fine_amt=? where book_id =? and std_id =? and status=0";
			PreparedStatement stmt1=con.prepareStatement(sql1);
			stmt1.setInt(1, fineAmount);
			stmt1.setInt(2, bookId);
			stmt1.setInt(3, studentId);
			stmt1.executeUpdate();
			System.out.println("Fine Updated");
			
		}
		else
		{
			System.out.println("No Due Pending");
		}
		String sql2="update details set status=1 , returned_date=sysdate where book_id =? and std_id =? and status=0";
		PreparedStatement stmt2=con.prepareStatement(sql2);
		stmt2.setInt(1, bookId);
		stmt2.setInt(2, studentId);
		stmt2.executeUpdate();
		}
		else
		{
			System.out.println("ThankYou....!");
		}
		}
		else
		{
			System.out.println("No Books Taken");
		}
		
		con.close();
	}

	public ArrayList<SummaryDetailsDueDate> displayStudentDetailsForDueDate(int bookId) throws Exception {
		Connection con=getConnection();
		String sql="select  d.std_id,s.std_name,s.std_dept,s.std_mob_no,d.book_id,b.book_name,d.issue_date,d.due_date from details d,books b ,student s where s.std_id=d.std_id and d.status=0 and b.book_id=d.book_id and d.book_id=?";
		System.out.println(sql);
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, bookId);
		ResultSet rs=stmt.executeQuery();
		ArrayList<SummaryDetailsDueDate> list=new ArrayList<SummaryDetailsDueDate>();
		while(rs.next())
		{
			SummaryDetailsDueDate ob=new SummaryDetailsDueDate();
			ob.studentId=rs.getInt("std_id");
			ob.studentName=rs.getString("std_name");
			ob.studentDept=rs.getString("std_dept");
			ob.mobileNumber=rs.getLong("std_mob_no");
			ob.bookId=rs.getInt("book_id");
			ob.bookName=rs.getString("book_name");
			ob.issueDate=rs.getDate("issue_date");
			ob.dueDate=rs.getDate("due_date");
			list.add(ob);
			}
		for (SummaryDetailsDueDate details : list) {
			System.out.println(details);
		}
		return list;
	}

	public void totalFineAmount() throws Exception {
		Connection con =getConnection();
		String sql="select sum(fine_amt) from details";
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		if(rs.next())
		{
			int fineAmount=rs.getInt("sum(fine_amt)");
			System.out.println("Sum of fine="+fineAmount);
		}
		con.close();
		
	}

	public ArrayList<SummaryDetailsStudentDetails> studentNotReturnedBook(int studentId) throws Exception {
		Connection con =getConnection();
		String sql="select  s.std_name,b.book_name,b.book_id,d.issue_date,d.due_date from details d,books b ,student s where s.std_id=d.std_id and d.status=0 and b.book_id=d.book_id and d.std_id=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, studentId);
		ResultSet rs=stmt.executeQuery();
		ArrayList<SummaryDetailsStudentDetails> list=new ArrayList<SummaryDetailsStudentDetails>();
		while(rs.next())
		{
			SummaryDetailsStudentDetails ob=new SummaryDetailsStudentDetails();
			ob.bookId=rs.getInt("book_id");
			ob.bookName=rs.getString("book_name");
			ob.issueDate=rs.getDate("issue_date");
			ob.duedate=rs.getDate("due_date");
			ob.studentName=rs.getString("std_name");
			list.add(ob);
		}
		for(SummaryDetailsStudentDetails details : list)
		{
			System.out.println(details);
		}
		con.close();
		return list;
	}
	
	
	
}
