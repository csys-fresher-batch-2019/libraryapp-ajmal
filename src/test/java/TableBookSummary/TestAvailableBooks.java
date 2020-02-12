package TableBookSummary;

import java.util.Scanner;

import com.chainsys.libraryapp.dao.implementation.SummaryDetailsDAOImp;

public class TestAvailableBooks {

	public static void main(String[] args) throws Exception {
		SummaryDetailsDAOImp ob=new SummaryDetailsDAOImp();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the book to be found available");
		int bookId=sc.nextInt();
		Integer remaining=null;
		remaining=ob.noOfBooksAvailable(bookId);
		if(remaining != null) {
			
		System.out.println(remaining);
		}
		else
		{
			System.out.println("This bookId doesn't exists..");
		}
		sc.close();
	}

}
