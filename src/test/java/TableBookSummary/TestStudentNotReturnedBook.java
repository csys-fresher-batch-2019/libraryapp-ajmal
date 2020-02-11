package TableBookSummary;

import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.libraryapp.Implementation.SummaryDetailsDAOImp;
import com.chainsys.libraryapp.LibaryModel.SummaryDetailsStudentDetails;

public abstract class TestStudentNotReturnedBook {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		SummaryDetailsDAOImp ob=new SummaryDetailsDAOImp();
		System.out.print("Enter the Student id : ");
		int studentId=sc.nextInt();
		
		ArrayList<SummaryDetailsStudentDetails> out = ob.studentNotReturnedBook(studentId);
		if(out != null)
		{
			for (SummaryDetailsStudentDetails details : out) {
				System.out.println(details);
			}
		}
		else
		{
			System.out.println("This Student has not taken any book");	
		}
		sc.close();
	}

}
