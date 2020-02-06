package AdminDetails;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class TestAddNewAdmin {

	public static void main(String[] args) throws Exception{
		AdminDetailsImp ob=new AdminDetailsImp();
		AdminDetails obj=new AdminDetails();
		Scanner sc=new Scanner(System.in);
		obj.adminName=sc.next();
		String dob=sc.next();
		obj.adminDOB=LocalDate.parse(dob);
		obj.admilMailId=sc.next();
		obj.adminMobileNo=sc.nextLong();
		obj.adminPassword=sc.next();
		obj.adminGender=sc.next();
		ob.addNewAdmin(obj);
		sc.close();
	}

}
