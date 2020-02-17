package AdminDetails;

import java.util.Scanner;

import com.chainsys.libraryapp.service.AdminDetailsService;

public class TestAdminLogin {

	public static void main(String[] args) throws Exception {
		AdminDetailsService ob=new AdminDetailsService();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter your mail id : ");
		String mailId=sc.next();
		System.out.print("Enter your Password : ");
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
