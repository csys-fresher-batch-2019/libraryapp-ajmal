package TableStudent;


import java.sql.Date;
import java.util.Scanner;

public class TestAddNewStudent {

	public static void main(String[] args) throws Exception {
		System.out.print("Entre values \nStudent Name :");
		Scanner sc= new Scanner(System.in);
	    String studentName = sc.nextLine();
	    System.out.print("Department : ");
	    String studentDepartment= sc.nextLine();
	    System.out.print("Date of Birth : ");
	    String dateOfBirth=sc.nextLine();
	    System.out.print("Mail Id :");
	    String studentMailId = sc.nextLine();
	    System.out.print("Mobile Number :");
	    long mobileNumber = sc.nextLong();
	    System.out.print("Year Of Joining :");
	    int yearOfJoin = sc.nextInt();
	    Date date = Date.valueOf(dateOfBirth);
	    
	    StudentDetailsImp obj =new StudentDetailsImp();
	    StudentDetails ob=new StudentDetails();
	    ob.studentName= studentName;
	    ob.studentDepatment= studentDepartment;
	    ob.dateOfBirth=date;
	    ob.studentMailId=studentMailId;
	    ob.mobileNumber=mobileNumber;
	    ob.yearOfJoin=yearOfJoin;
	    
	    obj.addStudentDetails(ob);
	    
	    

	}

}
