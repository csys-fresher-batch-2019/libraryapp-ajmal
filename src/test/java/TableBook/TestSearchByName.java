package TableBook;

import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.libaryapp.service.BookDetailsService;
import com.chainsys.libraryapp.LibaryModel.BookDetails;

public class TestSearchByName {

	public static void main(String[] args) throws Exception {
		BookDetailsService  ob=new BookDetailsService();
		ArrayList<BookDetails> list =new ArrayList<>();
		System.out.print("Enter the name to be searched : ");
		Scanner sc=new Scanner(System.in);
		String bookName= sc.next();
		list=ob.searchByName(bookName);
		for(BookDetails details:list)
		{
			System.out.println(details);
		}
		sc.close();

	}

}
