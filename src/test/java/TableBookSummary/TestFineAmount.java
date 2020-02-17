package TableBookSummary;

import java.util.Scanner;

import com.chainsys.libraryapp.service.SummaryDetailsService;

public class TestFineAmount {

	public static void main(String[] args) throws Exception {
		SummaryDetailsService ob=new SummaryDetailsService();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the BookId : ");
		int bookId=sc.nextInt();
		System.out.print("Enter the StudentId : ");
		int studentId=sc.nextInt();
		Integer fineAmount=ob.calculateFineAmount(studentId, bookId);
		System.out.println("Fine Amount = "+fineAmount);
		sc.close();		
	}

}
	