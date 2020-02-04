package TableBookSummary;

import java.util.Scanner;

public class TestBookEntry {

	public static void main(String[] args) throws Exception {
		SummaryDetailsImp ob=new SummaryDetailsImp();
		Scanner sc =new Scanner(System.in);
		System.out.print("Enter Book ID : ");
		int bookId = sc.nextInt();
		System.out.print("Rnter Student ID : ");
		int studentId=sc.nextInt();
		ob.addNewEntry(studentId, bookId);

	}

}
 		