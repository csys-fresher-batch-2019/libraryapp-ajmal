package com.chainsys.libraryapp.service;

import java.util.ArrayList;

import com.chainsys.libraryapp.LibaryModel.StudentDetails;
import com.chainsys.libraryapp.dao.StudentDetailsDAO;
import com.chainsys.libraryapp.dao.implementation.StudentDetailsDAOImp;

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
