package AdminDetails;

import java.time.LocalDate;
import java.util.Scanner;

import com.chainsys.libraryapp.LibaryModel.AdminDetails;
import com.chainsys.libraryapp.service.AdminDetailsService;

public abstract class TestAddNewAdmin {

	public static void main(String[] args) throws Exception{
		AdminDetailsService ob=new AdminDetailsService();
		AdminDetails obj=new AdminDetails();
		System.out.print("Creation Of New Admin \n Enter Name : ");
		Scanner sc=new Scanner(System.in);
		obj.setAdminName(sc.next());
		System.out.print("Date Of Birth (yyyy-MM-dd) : ");
		String dob=sc.next();
		obj.setAdminDOB(LocalDate.parse(dob));
		System.out.print("Mail Id : ");
		obj.setAdmilMailId(sc.next());
		System.out.print("Mobile Number (10-Digits): ");
		long mnum = sc.nextLong();

		if((int)(Math.log10(mnum)+1)==10)
		{
		obj.setAdminMobileNo(mnum);
		}
		else
		{
			System.out.println("Enter the valid 10 digit number");
			TestAddNewAdmin.main(null);
		}
		System.out.print("Crete A password : ");
		obj.setAdminPassword(sc.next());
		System.out.print("Gender (Male/Female) : ");
		obj.setAdminGender(sc.next());
		ob.addNewAdmin(obj);
		System.out.println("updated");
		sc.close();
	}

}
