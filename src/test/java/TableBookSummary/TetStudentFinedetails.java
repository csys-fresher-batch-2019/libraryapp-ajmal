package TableBookSummary;

import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.libraryapp.Implementation.SummaryDetailsDAOImp;
import com.chainsys.libraryapp.LibaryModel.StudentFineSummaryDetails;

public class TetStudentFinedetails {

	public static void main(String[] args) throws Exception {
		SummaryDetailsDAOImp ob= new SummaryDetailsDAOImp();
		Scanner sc=new Scanner(System.in);
		//To calculate the Total Fine amount of a student along with their not Returned books
		System.out.print("Enter the Student Id : ");
		int studentId=sc.nextInt();
		int totalFineAmount=0;
		String name = null;
		ArrayList<StudentFineSummaryDetails> out=ob.totalFineAmountOfStudent(studentId);
		for(StudentFineSummaryDetails details:out)
		{
			name = details.getStudentName();
			totalFineAmount=totalFineAmount+details.getFineAmount();
		}
		System.out.println("StudentName : "+name);
		System.out.println("Total Fine Amount : "+totalFineAmount);
		for(StudentFineSummaryDetails details:out)
		{
		System.out.println(details);
		}
		sc.close();
	}

}
