package TableBook;

import java.util.Scanner;

import com.chainsys.libraryapp.LibaryModel.BookDetails;
import com.chainsys.libraryapp.service.BookDetailsService;

public class TestDisplayBookDetails {

	public static void main(String[] args) throws Exception {
		BookDetailsService ob=new BookDetailsService();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the bookId : ");
		int bookId=sc.nextInt();
		BookDetails out=new BookDetails();
		out=ob.displayBook(bookId);
		if(out !=null)
		{
		System.out.print(out);
		}
		else
		{
			System.out.println("No Book Found, Please Enter A valid BookId\n");
			TestDisplayBookDetails.main(args);
		}
		sc.close();
	}

}
