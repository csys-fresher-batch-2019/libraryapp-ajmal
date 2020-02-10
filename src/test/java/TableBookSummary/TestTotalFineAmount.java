package TableBookSummary;

import com.chainsys.libraryapp.Implementation.SummaryDetailsImp;

public class TestTotalFineAmount {

	public static void main(String[] args) throws Exception {
		SummaryDetailsImp ob=new SummaryDetailsImp();
		int total =ob.totalFineAmount();
		System.out.println("Sum of fine=" + total);
	}

}
