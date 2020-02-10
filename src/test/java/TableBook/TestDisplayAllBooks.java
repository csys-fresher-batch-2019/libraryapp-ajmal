package TableBook;

import java.util.ArrayList;

import com.chainsys.libraryapp.Implementation.BookDetailsImp;
import com.chainsys.libraryapp.LibaryModel.BookDetails;

public class TestDisplayAllBooks {

	public static void main(String[] args) throws Exception {
		BookDetailsImp ob=new BookDetailsImp();
		ArrayList<BookDetails> out= new ArrayList<BookDetails>();
		out=ob.displayAllBooks();
		for(BookDetails details:out)
		{
			System.out.println(details);
		}

	}

}
