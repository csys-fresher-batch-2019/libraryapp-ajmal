package TableStudent;

import java.sql.Date;

public class StudentDetails {
public int studentId;
public String studentName;
public String studentDepatment;
public Date dateOfBirth;
public String studentMailId;
public long mobileNumber;
public int yearOfJoin;
@Override
public String toString() {
	return "StudentDetails [studentId=" + studentId + ", studentName=" + studentName + ", studentDepatment="
			+ studentDepatment + ", dateOfBirth=" + dateOfBirth + ", studentMailId=" + studentMailId + ", mobileNumber="
			+ mobileNumber + ", yearOfJoin=" + yearOfJoin + "]";
}





}
