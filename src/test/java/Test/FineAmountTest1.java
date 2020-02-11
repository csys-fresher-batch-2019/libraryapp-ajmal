package Test;

import org.junit.Assert;

import com.chainsys.libaryapp.service.SummaryDetailsService;


public class FineAmountTest1 {

	public static void main(String[] args) throws Exception {
		int studentId=1004;
		int bookId=103;
		int e=152;
		SummaryDetailsService ob=new SummaryDetailsService();
		int o=ob.calculateFineAmount(studentId, bookId);
		System.out.println(o);
		Assert.assertEquals(e, o);
		
		

	}

}
