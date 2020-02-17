package TableBookSummary;

import java.util.Scanner;

import com.chainsys.libraryapp.service.SummaryDetailsService;

public class TestBookEntryOfStudent {

	public static void main(String[] args) throws Exception {
		SummaryDetailsService ob=new SummaryDetailsService();
		Scanner sc =new Scanner(System.in);
		System.out.print("Enter Book ID : ");
		int bookId = sc.nextInt();
		System.out.print("Enter Student ID : ");
		int studentId=sc.nextInt();
		boolean out=ob.addNewEntry(studentId, bookId);
		if(out)
		{
			System.out.println("Inserted");
		}
		else
		{
			System.out.println("You have already taken this book, Try another");
		}
		sc.close();
	}

}
 		