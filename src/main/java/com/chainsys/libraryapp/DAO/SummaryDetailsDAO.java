package com.chainsys.libraryapp.DAO;

import java.util.ArrayList;

import com.chainsys.libraryapp.LibaryModel.StudentFineSummaryDetails;
import com.chainsys.libraryapp.LibaryModel.SummaryDetailsDueDate;
import com.chainsys.libraryapp.LibaryModel.SummaryDetailsStudentDetails;

public interface SummaryDetailsDAO {
	public void addNewEntry(int studentId,int bookId)throws Exception;
	public Integer calculateFineAmount(int studentId,int BookId)throws Exception;
	public void updateReturnRecord(int studentId, int bookId, Integer fineAmount) throws Exception;
	public ArrayList<SummaryDetailsDueDate> displayStudentDetailsForDueDate(int bookId) throws Exception;
	public int totalFineAmount() throws Exception;
	public ArrayList<SummaryDetailsStudentDetails> studentNotReturnedBook(int studentId)throws Exception;
	public boolean bookTaken(int studentId,int bookId)throws Exception;
	public ArrayList<StudentFineSummaryDetails> totalFineAmountOfStudent(int studentId) throws Exception;
}
