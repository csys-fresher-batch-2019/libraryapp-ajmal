package TableBook;

import java.sql.Date;
import java.util.Scanner;


public class TestAddBookDetails {

	public static void main(String[] args) throws Exception {
		
		BookDetailsImp obj=new BookDetailsImp();
		
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
		ob.bookName=bookName;
		ob.bookCategory=bookCategory;
		ob.bookAutherName=bookAuthor;
		ob.bookEdition=bookEdition;
		ob.bookPages=bookPages;
		ob.bookCopies=bookCopies;
		ob.bookPrice=bookPrice;
		ob.bookPurchasedDate=date;
		
		
		obj.addNewBook(ob);	
		sc.close();
    
	
	}

}

