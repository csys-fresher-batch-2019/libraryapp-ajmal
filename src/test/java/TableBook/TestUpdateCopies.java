package TableBook;

import java.util.Scanner;

import com.chainsys.libraryapp.LibaryModel.BookDetails;
import com.chainsys.libraryapp.dao.implementation.BookDetailsDAOImp;

public class TestUpdateCopies {

	public static void main(String[] args) throws Exception {
	BookDetailsDAOImp obj= new BookDetailsDAOImp();
	Scanner sc = new Scanner(System.in);
	String bookName= sc.nextLine();
	int bookEdition=sc.nextInt();
	int bookCopies= sc.nextInt();
	BookDetails ob = new BookDetails();
	ob.setBookName(bookName);
	ob.setBookEdition(bookEdition);
	ob.setBookCopies(bookCopies);
	System.out.println(ob);
	obj.updateBookCopies(ob);
	sc.close();

	}

}
