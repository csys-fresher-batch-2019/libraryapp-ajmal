package TableStudent;

import java.sql.Date;

import com.chainsys.libraryapp.dao.implementation.StudentDetailsDAOImp;
import com.chainsys.libraryapp.exception.DbException;

public class TestStudentLogin {

	public static void main(String[] args) throws DbException {
		StudentDetailsDAOImp ob=new StudentDetailsDAOImp();
		int studentId=1001;
		Date dob=ob.studentLogin(studentId);
		System.out.println(dob);

	}

}
