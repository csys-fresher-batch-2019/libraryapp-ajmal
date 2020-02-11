package Test;

import org.junit.Assert;

import com.chainsys.libraryapp.dao.implementation.SummaryDetailsDAOImp;

public class FineAmountTest {
	
	
	public static void main(String[] args) throws Exception {
	int studentId=1004;
	int bookId=102;
	int expected=0;
	SummaryDetailsDAOImp ob=new SummaryDetailsDAOImp();
	int actual=ob.calculateFineAmount(studentId, bookId);
	Assert.assertEquals(expected, actual);
	System.out.println("Done");
	}
}
