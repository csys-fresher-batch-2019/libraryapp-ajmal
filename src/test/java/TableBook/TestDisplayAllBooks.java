package TableBook;

import java.util.ArrayList;

import com.chainsys.libraryapp.LibaryModel.BookDetails;
import com.chainsys.libraryapp.dao.implementation.BookDetailsDAOImp;

public class TestDisplayAllBooks {

	public static void main(String[] args) throws Exception {
		BookDetailsDAOImp ob=new BookDetailsDAOImp();
		ArrayList<BookDetails> out= new ArrayList<BookDetails>();
		out=ob.displayAllBooks();
		for(BookDetails details:out)
		{
			System.out.println(details);
		}

	}

}
