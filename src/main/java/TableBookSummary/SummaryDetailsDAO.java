package TableBookSummary;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import Libary3.SummaryDetailsDueDate;

public interface SummaryDetailsDAO {
	public void addNewEntry(int studentId,int bookId)throws Exception;
	public int calculateFineAmount(int studentId,int BookId)throws Exception;
	public void updateReturnRecord(int studentId, int bookId) throws Exception;
	public ArrayList<SummaryDetailsDueDate> displayStudentDetailsForDueDate(int bookId) throws Exception;
}
