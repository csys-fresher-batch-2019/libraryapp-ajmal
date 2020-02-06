package TableBookSummary;

import java.util.Scanner;

public class TestFineAmount {

	public static void main(String[] args) throws Exception {
		SummaryDetailsImp ob=new SummaryDetailsImp();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the BookId : ");
		int bookId=sc.nextInt();
		System.out.print("Enter the StudentId : ");
		int studentId=sc.nextInt();
		int fineAmount=ob.calculateFineAmount(studentId, bookId);
		
		System.out.println(fineAmount);
		sc.close();
		
			
	}

}
