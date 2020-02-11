package AdminDetails;

import java.time.LocalDate;
import java.util.Scanner;

import com.chainsys.libraryapp.LibaryModel.AdminDetails;
import com.chainsys.libraryapp.dao.implementation.AdminDetailsDAOImp;

public abstract class TestAddNewAdmin {

	public static void main(String[] args) throws Exception{
		AdminDetailsDAOImp ob=new AdminDetailsDAOImp();
		AdminDetails obj=new AdminDetails();
		Scanner sc=new Scanner(System.in);
		obj.setAdminName(sc.next());
		String dob=sc.next();
		obj.setAdminDOB(LocalDate.parse(dob));
		obj.setAdmilMailId(sc.next());
		obj.setAdminMobileNo(sc.nextLong());
		obj.setAdminPassword(sc.next());
		obj.setAdminGender(sc.next());
		ob.addNewAdmin(obj);
		sc.close();
	}

}
