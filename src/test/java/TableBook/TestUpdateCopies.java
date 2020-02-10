package TableBook;

import java.util.Scanner;

import com.chainsys.libraryapp.Implementation.BookDetailsImp;
import com.chainsys.libraryapp.LibaryModel.BookDetails;

public class TestUpdateCopies {

	public static void main(String[] args) throws Exception {
	BookDetailsImp obj= new BookDetailsImp();
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
