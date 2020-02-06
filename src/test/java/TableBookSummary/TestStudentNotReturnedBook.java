package TableBookSummary;

import java.util.Scanner;

public abstract class TestStudentNotReturnedBook {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		SummaryDetailsImp ob=new SummaryDetailsImp();
		System.out.print("Enter the Student id : ");
		int studentId=sc.nextInt();
		ob.studentNotReturnedBook(studentId);
		sc.close();
	}

}
