package TableBook;

import java.sql.Date;
import java.util.Scanner;

import com.chainsys.libraryapp.Implementation.BookDetailsDAOImp;
import com.chainsys.libraryapp.LibaryModel.BookDetails;


public class TestAddBookDetails {

	public static void main(String[] args) throws Exception {
		
		BookDetailsDAOImp obj=new BookDetailsDAOImp();
		
System.out.print("Entre values \nBook Name :");
	Scanner sc= new Scanner(System.in);
    String bookName = sc.nextLine();
    System.out.print("Category : ");
    String bookCategory= sc.nextLine();
    System.out.print("Author Name : ");
    String bookAuthor=sc.nextLine();
    System.out.print("Edition : ");
    int bookEdition=sc.nextInt();
    System.out.print("Price of the book : ");
    int bookPrice=sc.nextInt();
    System.out.print("Copies : ");
    int bookCopies=sc.nextInt();
    System.out.print("Pages of book : ");
    int bookPages=sc.nextInt();
    sc.nextLine();
    System.out.print("Purchased Date : ");
    String bookPurchasedDate = sc.next();
    Date date = Date.valueOf(bookPurchasedDate);
    
		BookDetails ob=new BookDetails();
		ob.setBookName(bookName);
		ob.setBookCategory(bookCategory);
		ob.setBookAutherName(bookAuthor);
		ob.setBookEdition(bookEdition);
		ob.setBookPages(bookPages);
		ob.setBookCopies(bookCopies);
		ob.setBookPrice(bookPrice);
		ob.setBookPurchasedDate(date);
		
		
		obj.addNewBook(ob);	
		sc.close();
    
	
	}

}

