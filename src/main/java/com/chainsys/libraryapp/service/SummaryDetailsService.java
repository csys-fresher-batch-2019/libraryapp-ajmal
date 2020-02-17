package com.chainsys.libraryapp.service;

import java.util.ArrayList;

import com.chainsys.libraryapp.LibaryModel.StudentFineSummaryDetails;
import com.chainsys.libraryapp.LibaryModel.SummaryDetailsDueDate;
import com.chainsys.libraryapp.LibaryModel.SummaryDetailsStudentDetails;
import com.chainsys.libraryapp.dao.SummaryDetailsDAO;
import com.chainsys.libraryapp.dao.implementation.SummaryDetailsDAOImp;

public class SummaryDetailsService {
	private SummaryDetailsDAO summaryDetailsDAO=new SummaryDetailsDAOImp();
	
	public boolean addNewEntry(int studentId,int bookId)throws Exception{
		return summaryDetailsDAO.addNewEntry(studentId, bookId);
	}
	public Integer calculateFineAmount(int studentId,int bookId)throws Exception{
		boolean bookTaken=summaryDetailsDAO.bookTaken(studentId, bookId);
		Integer fine=0;
		if(!bookTaken)
		{
			throw new Exception("You have not taken book");
		}
		fine =  summaryDetailsDAO.calculateFineAmount(studentId, bookId);
		return fine;
	}
	public void updateReturnRecord(int studentId, int bookId, Integer fineAmount) throws Exception{
		summaryDetailsDAO.updateReturnRecord(studentId, bookId, fineAmount);
	}
	public ArrayList<SummaryDetailsDueDate> displayStudentNotReturnedBook(int bookId) throws Exception{
		return summaryDetailsDAO.displayStudentNotReturnedBook(bookId);
	}
	public int totalFineAmount() throws Exception{
		return summaryDetailsDAO.totalFineAmount();
	}
	public ArrayList<SummaryDetailsStudentDetails> studentNotReturnedBook(int studentId)throws Exception{
		return summaryDetailsDAO.studentNotReturnedBook(studentId);
	}
	public boolean bookTaken(int studentId,int bookId)throws Exception{
		return summaryDetailsDAO.bookTaken(studentId, bookId);
	}
	public ArrayList<StudentFineSummaryDetails> totalFineAmountOfStudent(int studentId) throws Exception{
		return summaryDetailsDAO.totalFineAmountOfStudent(studentId);
	}
	public Integer noOfBooksAvailable(int bookId) throws Exception{
		return summaryDetailsDAO.noOfBooksAvailable(bookId);
	}

}
