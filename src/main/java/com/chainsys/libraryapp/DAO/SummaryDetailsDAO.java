package com.chainsys.libraryapp.dao;

import java.util.ArrayList;

import com.chainsys.libraryapp.LibaryModel.StudentFineSummaryDetails;
import com.chainsys.libraryapp.LibaryModel.SummaryDetailsDueDate;
import com.chainsys.libraryapp.LibaryModel.SummaryDetailsStudentDetails;
import com.chainsys.libraryapp.exception.DbException;

public interface SummaryDetailsDAO {
	public boolean addNewEntry(int studentId,int bookId)throws DbException;
	public Integer calculateFineAmount(int studentId,int BookId)throws DbException;
	public void updateReturnRecord(int studentId, int bookId, Integer fineAmount) throws DbException;
	public ArrayList<SummaryDetailsDueDate> displayStudentNotReturnedBook(int bookId) throws DbException;
	public int totalFineAmount() throws DbException;
	public ArrayList<SummaryDetailsStudentDetails> studentNotReturnedBook(int studentId)throws DbException;
	public boolean bookTaken(int studentId,int bookId)throws DbException;
	public ArrayList<StudentFineSummaryDetails> totalFineAmountOfStudent(int studentId) throws DbException;
	public Integer noOfBooksAvailable(int bookId) throws DbException;
	public boolean limitForStudent(int studentId)throws DbException;
}
