package TableBook;

import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.libraryapp.LibaryModel.BookDetails;
import com.chainsys.libraryapp.service.BookDetailsService;

public class TestSearchByName {

	public static void main(String[] args) throws Exception {
		BookDetailsService  ob=new BookDetailsService();
		ArrayList<BookDetails> list =new ArrayList<>();
		System.out.print("Enter the name to be searched : ");
		Scanner sc=new Scanner(System.in);
		String bookName= sc.next();
		list=ob.searchByName(bookName);
		boolean result=false;
		for(BookDetails details:list)
		{
			result=true;
			System.out.println(details);
		}
		if(!result) {
			
		System.out.println("Enter The Correct Name of the Book to Found");
		TestSearchByName.main(null);
		}
		sc.close();

	}

}
