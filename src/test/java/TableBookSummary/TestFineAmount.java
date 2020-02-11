package TableBookSummary;

import java.util.Scanner;

import com.chainsys.libraryapp.dao.implementation.SummaryDetailsDAOImp;

public class TestFineAmount {

	public static void main(String[] args) throws Exception {
		SummaryDetailsDAOImp ob=new SummaryDetailsDAOImp();
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
	