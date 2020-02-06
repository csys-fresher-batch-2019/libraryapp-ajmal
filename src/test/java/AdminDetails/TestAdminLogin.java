package AdminDetails;

import java.util.Scanner;

public class TestAdminLogin {

	public static void main(String[] args) throws Exception {
		AdminDetailsImp ob=new AdminDetailsImp();
		Scanner sc=new Scanner(System.in);
		String mailId=sc.next();
		String password=sc.next();
		ob.userLogin(mailId, password);
		sc.close();
	}

}
