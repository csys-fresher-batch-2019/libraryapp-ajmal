package TableBook;

import java.util.ArrayList;

public interface BookDetailsDAO {
	 public void addNewBook(BookDetails bookdetails)throws Exception;
	 public void updateBookCopies(BookDetails bookdetails)throws Exception;
	 public BookDetails displayBook(int bookId)throws Exception;
	public ArrayList<BookDetails> displayAllBooks()throws Exception;

}
