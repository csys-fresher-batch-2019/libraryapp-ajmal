package AdminDetails;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDetailsImp implements AdminDetailsDAO{
	public static Connection getConnection() throws Exception {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			//System.out.println(connection);
			return connection;
		
	}

	public void addNewAdmin(AdminDetails admindetails) throws Exception {
		Connection con=getConnection();
		
		String sql="insert into admin(admin_name,admin_dob,admin_mail_id,admin_mob_no,admin_password,admin_gender,admin_id) values (?,?,?,?,?,?,admin_id_seq.nextval)";
		System.out.println(sql);
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,admindetails.adminName);
	    stmt.setDate(2, Date.valueOf(admindetails.adminDOB));
	    stmt.setString(3, admindetails.admilMailId);
	    stmt.setLong(4, admindetails.adminMobileNo);
	    stmt.setString(5, admindetails.adminPassword);
	    stmt.setString(6, admindetails.adminGender);
	    int row=stmt.executeUpdate();
	    System.out.println(row);
	    con.close();
		
	}

	public void userLogin(String mailId, String password) throws Exception {
		Connection con=getConnection();
		String sql="select * from admin where admin_mail_id=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1, mailId);
		ResultSet rs=stmt.executeQuery();
		String password1=null;
		while(rs.next())
		{
			password1=rs.getString("admin_password");
		}
		if(password1.contentEquals(password))
		{
			System.out.println("Succesfully LogedIn");
		}
		else
		{
			System.out.println("Wrong password");
		}
		con.close();
	}

}
