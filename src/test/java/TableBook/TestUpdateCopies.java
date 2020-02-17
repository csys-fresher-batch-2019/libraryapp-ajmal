package TableBook;

import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.libraryapp.LibaryModel.BookDetails;
import com.chainsys.libraryapp.service.BookDetailsService;

public class TestUpdateCopies {

	public static void main(String[] args) throws Exception {
	BookDetailsService obj= new BookDetailsService();
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the Book Name : ");
	String bookName= sc.nextLine();
	ArrayList<BookDetails> list=new ArrayList<>();
	list=obj.searchByName(bookName);
	for(BookDetails details:list)
	{
		System.out.println(details);
	}
	System.out.print("Enter the book Id to be cganged from the list : ");
	int bookId=sc.nextInt();
	System.out.print("Enter the Copies to be Added : ");
	int bookCopies= sc.nextInt();
	obj.updateBookCopies(bookId,bookCopies);
	System.out.println("Updated");
	sc.close();

	}

}
