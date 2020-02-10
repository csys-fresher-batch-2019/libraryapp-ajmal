package TableBookSummary;

import java.util.Scanner;

import com.chainsys.libraryapp.Implementation.SummaryDetailsImp;

public class TestFineAmount {

	public static void main(String[] args) throws Exception {
		SummaryDetailsImp ob=new SummaryDetailsImp();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the BookId : ");
		int bookId=sc.nextInt();
		System.out.print("Enter the StudentId : ");
		int studentId=sc.nextInt();
		boolean taken=ob.bookTaken(studentId, bookId);
		if(taken)
		{
		Integer fineAmount=ob.calculateFineAmount(studentId, bookId);
		System.out.println("Fine Amount = "+fineAmount);
		}
		else
		{
			System.out.println("No Book has Taken");
		}
		
		
		
		sc.close();
		
			
	}

}
	