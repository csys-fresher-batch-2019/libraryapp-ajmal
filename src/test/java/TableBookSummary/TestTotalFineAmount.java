package TableBookSummary;

import com.chainsys.libraryapp.service.SummaryDetailsService;

public class TestTotalFineAmount {

	public static void main(String[] args) throws Exception {
		SummaryDetailsService ob=new SummaryDetailsService();
		int total =ob.totalFineAmount();
		System.out.println("Tootal Fine = " + total);
	}

}
