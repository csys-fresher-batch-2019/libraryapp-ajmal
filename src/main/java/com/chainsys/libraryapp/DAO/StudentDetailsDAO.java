package com.chainsys.libraryapp.dao;

import java.util.ArrayList;

import com.chainsys.libraryapp.LibaryModel.StudentDetails;
import com.chainsys.libraryapp.exception.DbException;


public interface StudentDetailsDAO {
	public void addStudentDetails(StudentDetails studentdetails)throws DbException;
	public StudentDetails displayStudentDetail(int studentId)throws DbException;
	public ArrayList<StudentDetails> displayAllStudents()throws DbException;
	
}
