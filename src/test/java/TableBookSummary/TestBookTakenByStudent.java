package TableBookSummary;

import java.util.Scanner;

import com.chainsys.libraryapp.service.SummaryDetailsService;

public class TestBookTakenByStudent {

	public static void main(String[] args) throws Exception {
		SummaryDetailsService ob=new SummaryDetailsService();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the BookId : ");
		int bookId=sc.nextInt();
		System.out.print("Enter the StudentId : ");
		int studentId=sc.nextInt();
		boolean taken=ob.bookTaken(studentId, bookId);
		if ( taken)
		{
			System.out.println("Book has Already Taken");

		}
		else
		{
			System.out.println("No Book has Taken");
		}
		sc.close();
		

	}

}
