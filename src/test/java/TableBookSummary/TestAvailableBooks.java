package TableBookSummary;

import java.util.Scanner;

import com.chainsys.libraryapp.Implementation.SummaryDetailsDAOImp;

public class TestAvailableBooks {

	public static void main(String[] args) throws Exception {
		SummaryDetailsDAOImp ob=new SummaryDetailsDAOImp();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the book to be found available");
		int bookId=sc.nextInt();
		int remaining=ob.noOfBooksAvailable(bookId);
		System.out.println(remaining);
		sc.close();
	}

}
