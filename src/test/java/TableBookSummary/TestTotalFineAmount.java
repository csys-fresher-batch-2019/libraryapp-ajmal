package TableBookSummary;

import com.chainsys.libraryapp.Implementation.SummaryDetailsDAOImp;

public class TestTotalFineAmount {

	public static void main(String[] args) throws Exception {
		SummaryDetailsDAOImp ob=new SummaryDetailsDAOImp();
		int total =ob.totalFineAmount();
		System.out.println("Sum of fine=" + total);
	}

}
