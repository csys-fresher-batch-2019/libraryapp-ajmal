package TableBookSummary;

import java.util.Scanner;

import com.chainsys.libraryapp.dao.implementation.SummaryDetailsDAOImp;

public class TestRenualOfABook {

	public static void main(String[] args) throws Exception {
		SummaryDetailsDAOImp ob=new SummaryDetailsDAOImp();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the BookId : ");
		int bookId=sc.nextInt();
		System.out.print("Enter the StudentId : ");
		int studentId=sc.nextInt();
		
		
		Integer fineAmount=ob.calculateFineAmount(studentId, bookId);
		System.out.println("Fine Amount = "+fineAmount+"\nDo you want to return (Y/N) - ");
		String output=sc.next();
		if(output.equalsIgnoreCase("Y"))
		{
			ob.updateReturnRecord(studentId, bookId,fineAmount);
			ob.addNewEntry(studentId, bookId);
		}
		else
		{
			System.out.println("ThankYou...!");
		}
		
		sc.close();
		

	}

}
