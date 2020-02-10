package TableBook;

import java.util.Scanner;

import com.chainsys.libraryapp.Implementation.BookDetailsImp;
import com.chainsys.libraryapp.LibaryModel.BookDetails;

public class TestDisplayBookDetails {

	public static void main(String[] args) throws Exception {
		BookDetailsImp ob=new BookDetailsImp();
		Scanner sc = new Scanner(System.in);
		int bookId=sc.nextInt();
		BookDetails out=new BookDetails();
		out=ob.displayBook(bookId);
		if(out !=null)
		{
		System.out.print(out);
		}
		else
		{
			System.out.println("no book Found");
		}
		sc.close();
	}

}
