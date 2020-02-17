package TableBookSummary;

import java.util.Scanner;

import com.chainsys.libraryapp.service.SummaryDetailsService;

public class TestAvailableBooks {

	public static void main(String[] args) throws Exception {
		SummaryDetailsService ob=new SummaryDetailsService();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the bookId to be found available : ");
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
