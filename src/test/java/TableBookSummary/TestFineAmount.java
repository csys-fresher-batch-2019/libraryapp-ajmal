package TableBookSummary;

import java.util.Scanner;

public class TestFineAmount {

	public static void main(String[] args) throws Exception {
		SummaryDetailsImp ob=new SummaryDetailsImp();
		Scanner sc=new Scanner(System.in);
		int bookId=sc.nextInt();
		int studentId=sc.nextInt();
		int fineAmount=ob.calculateFineAmount(studentId, bookId);
		
		System.out.println(fineAmount);
		//LocalDate returnedDate=LocalDate.now();
		//ob.updateReturnRecord(studentId, bookId);
		
			
	}

}
