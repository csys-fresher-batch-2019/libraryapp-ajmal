package TableBook;

import java.util.Scanner;

public class TestDisplayBookDetails {

	public static void main(String[] args) throws Exception {
		BookDetailsImp ob=new BookDetailsImp();
		Scanner sc = new Scanner(System.in);
		int bookId=sc.nextInt();
		ob.displayBook(bookId);
	}

}
