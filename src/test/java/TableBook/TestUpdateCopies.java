package TableBook;

import java.util.Scanner;

public class TestUpdateCopies {

	public static void main(String[] args) throws Exception {
	BookDetailsImp obj= new BookDetailsImp();
	Scanner sc = new Scanner(System.in);
	String bookName= sc.nextLine();
	int bookEdition=sc.nextInt();
	int bookCopies= sc.nextInt();
	BookDetails ob = new BookDetails();
	ob.bookName=bookName;
	ob.bookEdition=bookEdition;
	ob.bookCopies=bookCopies;
	System.out.println(ob);
	obj.updateBookCopies(ob);
	sc.close();

	}

}
