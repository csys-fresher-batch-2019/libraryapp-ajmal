package TableStudent;

import java.util.Scanner;

import com.chainsys.libraryapp.LibaryModel.StudentDetails;
import com.chainsys.libraryapp.service.StudentDetailsService;

public class TestDisplayStudentDetail {

	public static void main(String[] args) throws Exception {
		StudentDetailsService ob=new StudentDetailsService();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Student Id - ");
		int studentId=sc.nextInt();
		StudentDetails obj= new StudentDetails();
		obj=ob.displayStudentDetail(studentId);
		if(obj !=null)
		{
			System.out.println(obj);
		}
		else
		{
			System.out.println("No student to Display, Enter A valid StudentId.....");
		}
		sc.close();
	}

}
