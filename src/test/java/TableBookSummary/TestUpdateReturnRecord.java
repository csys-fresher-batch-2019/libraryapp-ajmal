package TableBookSummary;

import java.util.Scanner;

public class TestUpdateReturnRecord {

	public static void main(String[] args) throws Exception {
		SummaryDetailsImp ob=new SummaryDetailsImp();
		Scanner sc=new Scanner(System.in);
		int bookId=sc.nextInt();
		int studentId=sc.nextInt();
		ob.updateReturnRecord(studentId, bookId);
		

	}

}
