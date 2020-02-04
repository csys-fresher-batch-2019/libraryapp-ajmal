package TableStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class StudentDetailsImp implements StudentDetailsDAO
{
	public static Connection getConnection() throws Exception {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			//System.out.println(connection);
			return connection;
	}

	public void addStudentDetails(StudentDetails studentdetails) throws Exception {
		Connection con = getConnection();
		String sql="insert into student(std_name,std_dept,std_dob,std_mail_id,std_mob_no,joining_yr,std_id) values(?,?,?,?,?,?,std_seq.nextval)";
		System.out.println(sql);
		PreparedStatement stmt= con.prepareStatement(sql);
		stmt.setString(1,studentdetails.studentName);
		stmt.setString(2,studentdetails.studentDepatment);
		stmt.setDate(3,studentdetails.dateOfBirth);
		stmt.setString(4,studentdetails.studentMailId);
		stmt.setLong(5,studentdetails.mobileNumber);
		stmt.setInt(6,studentdetails.yearOfJoin);
		int row= stmt.executeUpdate();
		System.out.println(row);
	}

	public StudentDetails displayStudentDetail(int studentId) throws Exception {
		Connection con =getConnection();
		String sql= "select * from student where std_id=?";
		System.out.println(sql);
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1,studentId);
		ResultSet rs=stmt.executeQuery();
		StudentDetails ob=null;
		if(rs.next())
		{
			ob = new StudentDetails();
			ob.studentId=rs.getInt("std_id");
			ob.studentName=rs.getString("std_name");
			ob.studentDepatment=rs.getString("std_dept");
			ob.dateOfBirth=rs.getDate("std_dob");
			ob.studentMailId=rs.getString("std_mail_id");
			ob.mobileNumber=rs.getLong("std_mob_no");
			ob.yearOfJoin=rs.getInt("joining_yr");
			System.out.println(ob);
		}
		return ob;
	}

	public ArrayList<StudentDetails> displayAllStudents() throws Exception {
		Connection con=getConnection();
		String sql = "select * from student";
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs= stmt.executeQuery();
		ArrayList<StudentDetails> list= new ArrayList<StudentDetails>();
		while(rs.next())
		{
			StudentDetails obj=new StudentDetails();
			obj.studentId=rs.getInt("std_id");
			obj.studentName=rs.getString("std_name");
			obj.studentDepatment=rs.getString("std_dept");
			obj.dateOfBirth=rs.getDate("std_dob");
			obj.studentMailId=rs.getString("std_mail_id");
			obj.mobileNumber=rs.getLong("std_mob_no");
			obj.yearOfJoin=rs.getInt("joining_yr");
			list.add(obj);
			
		}
		for(StudentDetails studentdetails: list)
		{
			System.out.println(studentdetails);
		}
		return list;
	}

	
}
