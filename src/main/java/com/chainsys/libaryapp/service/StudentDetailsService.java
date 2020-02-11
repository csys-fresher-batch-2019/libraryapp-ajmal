package com.chainsys.libaryapp.service;

import java.util.ArrayList;

import com.chainsys.libraryapp.Implementation.StudentDetailsDAOImp;
import com.chainsys.libraryapp.LibaryModel.StudentDetails;
import com.chainsys.libraryapp.dao.StudentDetailsDAO;

public class StudentDetailsService {
	
	private StudentDetailsDAO studentDetailsDAO=new StudentDetailsDAOImp();
	
	public void addStudentDetails(StudentDetails studentdetails)throws Exception
	{
		studentDetailsDAO.addStudentDetails(studentdetails);
	}
	public StudentDetails displayStudentDetail(int studentId)throws Exception{
		return studentDetailsDAO.displayStudentDetail(studentId);
		}
	public ArrayList<StudentDetails> displayAllStudents()throws Exception{
		return studentDetailsDAO.displayAllStudents();
	}

}
