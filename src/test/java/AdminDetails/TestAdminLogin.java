package AdminDetails;

import java.util.Scanner;

import com.chainsys.libraryapp.Implementation.AdminDetailsImp;

public class TestAdminLogin {

	public static void main(String[] args) throws Exception {
		AdminDetailsImp ob=new AdminDetailsImp();
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