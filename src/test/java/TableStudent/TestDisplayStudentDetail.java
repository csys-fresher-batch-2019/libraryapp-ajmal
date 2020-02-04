package TableStudent;

import java.util.Scanner;

public class TestDisplayStudentDetail {

	public static void main(String[] args) throws Exception {
		StudentDetailsImp ob=new StudentDetailsImp();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Student Id - ");
		int studentId=sc.nextInt();
		ob.displayStudentDetail(studentId);

	}

}
