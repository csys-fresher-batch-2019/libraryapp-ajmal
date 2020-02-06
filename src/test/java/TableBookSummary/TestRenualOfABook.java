package TableBookSummary;

import java.util.Scanner;

public class TestRenualOfABook {

	public static void main(String[] args) throws Exception {
		SummaryDetailsImp ob=new SummaryDetailsImp();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the BookId : ");
		int bookId=sc.nextInt();
		System.out.print("Enter the StudentId : ");
		int studentId=sc.nextInt();
		ob.updateReturnRecord(studentId, bookId);
		ob.addNewEntry(studentId, bookId);
		sc.close();
		

	}

}
