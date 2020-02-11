package AdminDetails;

import java.util.Scanner;

import com.chainsys.libraryapp.Implementation.AdminDetailsDAOImp;

public class TestAdminLogin {

	public static void main(String[] args) throws Exception {
		AdminDetailsDAOImp ob=new AdminDetailsDAOImp();
		Scanner sc=new Scanner(System.in);
		String mailId=sc.next();
		String password=sc.next();
		Boolean out=ob.userLogin(mailId, password);
		if(out)
		{
			System.out.println("loggedIn");
		}
		else
		{
			System.out.println("Wrong Password");
		}
		sc.close();
	}

}
