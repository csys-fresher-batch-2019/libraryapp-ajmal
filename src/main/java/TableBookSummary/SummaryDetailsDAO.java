package TableBookSummary;

import java.util.ArrayList;

import Libary3.SummaryDetailsDueDate;
import Libary3.SummaryDetailsStudentDetails;

public interface SummaryDetailsDAO {
	public void addNewEntry(int studentId,int bookId)throws Exception;
	public int calculateFineAmount(int studentId,int BookId)throws Exception;
	public void updateReturnRecord(int studentId, int bookId) throws Exception;
	public ArrayList<SummaryDetailsDueDate> displayStudentDetailsForDueDate(int bookId) throws Exception;
	public void totalFineAmount() throws Exception;
	public ArrayList<SummaryDetailsStudentDetails> studentNotReturnedBook(int studentId)throws Exception;
}
