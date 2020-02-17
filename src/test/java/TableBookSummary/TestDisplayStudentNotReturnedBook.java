package TableBookSummary;

import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.libraryapp.LibaryModel.SummaryDetailsDueDate;
import com.chainsys.libraryapp.service.SummaryDetailsService;

public class TestDisplayStudentNotReturnedBook {

	public static void main(String[] args) throws Exception {
		SummaryDetailsService ob=new SummaryDetailsService();
		System.out.print("Enter the BookId to be found :");
		Scanner sc=new Scanner(System.in);
		int bookId=sc.nextInt();
		ArrayList<SummaryDetailsDueDate> out=new ArrayList<>();
		out=ob.displayStudentNotReturnedBook(bookId);
		if(out.isEmpty())
		{
			System.out.println("No books to return");
		}
		else
		{
			for(SummaryDetailsDueDate details:out)
			{
			System.out.println(details);
			}
		}
		sc.close();
	}

}
