package TableStudent;

import java.util.Scanner;

import com.chainsys.libraryapp.Implementation.StudentDetailsDAOImp;

public class TestDisplayStudentDetail {

	public static void main(String[] args) throws Exception {
		StudentDetailsDAOImp ob=new StudentDetailsDAOImp();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Student Id - ");
		int studentId=sc.nextInt();
		ob.displayStudentDetail(studentId);
		sc.close();
	}

}
