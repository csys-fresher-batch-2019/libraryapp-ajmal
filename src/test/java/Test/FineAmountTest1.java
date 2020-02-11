package Test;

import com.chainsys.libaryapp.service.SummaryDetailsService;

public class FineAmountTest1 {

	public static void main(String[] args) throws Exception {
		int studentId=1004;
		int bookId=103;
		SummaryDetailsService ob=new SummaryDetailsService();
		Integer fine=ob.calculateFineAmount(studentId, bookId);
		System.out.println(fine);
		

	}

}
