package TableBookSummary;

import java.time.LocalDate;
import java.util.Scanner;

public class TestFindUsingBookId {

	public static void main(String[] args) throws Exception {
		SummaryDetailsImp ob=new SummaryDetailsImp();
		System.out.println("Enter the BookId to be found :");
		Scanner sc=new Scanner(System.in);
		int bookId=sc.nextInt();
		ob.displayStudentDetailsForDueDate(bookId);
		sc.close();
	}

}
