package com.chainsys.libraryapp.DAO;

import java.util.ArrayList;

import com.chainsys.libraryapp.LibaryModel.StudentDetails;


public interface StudentDetailsDAO {
	public void addStudentDetails(StudentDetails studentdetails)throws Exception;
	public StudentDetails displayStudentDetail(int studentId)throws Exception;
	public ArrayList<StudentDetails> displayAllStudents()throws Exception;
	
}
