package TableStudent;

import java.util.ArrayList;


public interface StudentDetailsDAO {
	public void addStudentDetails(StudentDetails studentdetails)throws Exception;
	public StudentDetails displayStudentDetail(int studentId)throws Exception;
	public ArrayList<StudentDetails> displayAllStudents()throws Exception;
	
}
