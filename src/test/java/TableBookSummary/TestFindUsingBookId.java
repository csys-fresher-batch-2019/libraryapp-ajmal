package TableBookSummary;

import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.libraryapp.Implementation.SummaryDetailsDAOImp;
import com.chainsys.libraryapp.LibaryModel.SummaryDetailsDueDate;

public class TestFindUsingBookId {

	public static void main(String[] args) throws Exception {
		SummaryDetailsDAOImp ob=new SummaryDetailsDAOImp();
		System.out.print("Enter the BookId to be found :");
		Scanner sc=new Scanner(System.in);
		int bookId=sc.nextInt();
		ArrayList<SummaryDetailsDueDate> out=new ArrayList<>();
		out=ob.displayStudentDetailsForDueDate(bookId);
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
