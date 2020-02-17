package TableBookSummary;

import java.util.Scanner;

import com.chainsys.libraryapp.dao.implementation.SummaryDetailsDAOImp;
import com.chainsys.libraryapp.exception.DbException;

public class TestCheckLimitOfStudent {

	public static void main(String[] args) throws DbException {
		SummaryDetailsDAOImp ob= new SummaryDetailsDAOImp();
		System.out.print("Enter the Student Id to check : ");
		Scanner sc=new Scanner(System.in);
		int studentId=sc.nextInt();
		boolean out=ob.limitForStudent(studentId);
		if(out)
		{
			System.out.println("limt exceeds");
		}
		else
		{
			System.out.println("Limit Doesn't Exceed");
		}
		sc.close();
	}

}
