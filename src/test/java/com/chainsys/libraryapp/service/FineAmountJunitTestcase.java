package com.chainsys.libraryapp.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class FineAmountJunitTestcase {
	SummaryDetailsService ob=new SummaryDetailsService();
	
	
	@Test
	public void testValidDataWithFine() {
		int studentId = 1004;
		int bookId = 103;
		int expected = 152;				
		
			try {
				int actual = ob.calculateFineAmount(studentId, bookId);
				Assert.assertEquals(expected, actual);
				
			} catch (Exception e) {
				fail();
			}
		

	}
	@Test
	public void testValidDataWithFineAsZero() {
		int studentId = 1004;
		int bookId = 102;
		int expected = 0;				
		try {
			int actual = ob.calculateFineAmount(studentId, bookId);
			Assert.assertEquals(expected, actual);
		} catch (Exception e) {

			fail();
		}

	}
	
}
