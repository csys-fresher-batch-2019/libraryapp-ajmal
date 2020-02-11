package TableBookSummary;

import java.util.Scanner;

import com.chainsys.libraryapp.dao.implementation.SummaryDetailsDAOImp;

public class TestBookTakenByStudent {

	public static void main(String[] args) throws Exception {
		SummaryDetailsDAOImp ob=new SummaryDetailsDAOImp();
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
