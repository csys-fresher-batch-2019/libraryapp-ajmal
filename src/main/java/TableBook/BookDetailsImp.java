package TableBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class BookDetailsImp implements BookDetailsDAO{
	
	public static Connection getConnection() throws Exception {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			//System.out.println(connection);
			return connection;
		
	}

	public void addNewBook(BookDetails bookdetails) throws Exception {
		Connection con=getConnection();
		
		String sql = "insert into books(book_name,book_cat,book_author,book_edition,no_of_bks,no_of_pgs,purchased_date,book_price,book_id)values  (?,?,?,?,?,?,?,?,id_seq.nextval)";
		System.out.println(sql);
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,bookdetails.bookName);
	    stmt.setString(2, bookdetails.bookCategory);
	    stmt.setString(3, bookdetails.bookAutherName);
	    stmt.setInt(4, bookdetails.bookEdition);
	    stmt.setInt(5, bookdetails.bookCopies);
	    stmt.setInt(6, bookdetails.bookPages);
	    stmt.setDate(7,bookdetails.bookPurchasedDate );
	    stmt.setInt(8, bookdetails.bookPrice);
	    int row=stmt.executeUpdate();
	    System.out.println(row);
	    
	}


	public void updateBookCopies(BookDetails bookdetails) throws Exception {
		Connection con=getConnection();
		String sql=  "update books set no_of_bks=(no_of_bks+?) where book_name=? and book_edition=?";
		System.out.println(sql);
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, bookdetails.bookCopies);
		stmt.setString(2, bookdetails.bookName);
		stmt.setInt(3, bookdetails.bookEdition);
		int row = stmt.executeUpdate();
		System.out.println(row);
		
	}

	public BookDetails displayBook(int bookId) throws Exception {
		Connection con= getConnection();
		String sql="select * from books where book_id=?";
		System.out.println(sql);
		PreparedStatement stmt= con.prepareStatement(sql);
		stmt.setInt(1, bookId);
		ResultSet rs = stmt.executeQuery();
		BookDetails ob=null;
		if(rs.next())
		{
			ob = new BookDetails();
			ob.bookId=rs.getInt("book_id");
			ob.bookName= rs.getString("book_name");
			ob.bookCategory=rs.getString("book_cat");
			ob.bookAutherName=rs.getString("book_author");
			ob.bookEdition=rs.getInt("book_edition");
			ob.bookPrice=rs.getInt("book_price");
			ob.bookPurchasedDate=rs.getDate("purchased_date");
			ob.bookCopies=rs.getInt("no_of_bks");
			ob.bookPages=rs.getInt("no_of_pgs");
			System.out.println(ob);
		}
		
		return ob;
	}

	public ArrayList<BookDetails> displayAllBooks() throws Exception {
		Connection con=getConnection();
		String sql ="select * from books";
		System.out.println(sql);
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		ArrayList<BookDetails> list= new ArrayList<BookDetails>();
		
		while(rs.next())
		{
			BookDetails ob= new BookDetails();
			ob.bookId=rs.getInt("book_id");
			ob.bookName= rs.getString("book_name");
			ob.bookCategory=rs.getString("book_cat");
			ob.bookAutherName=rs.getString("book_author");
			ob.bookEdition=rs.getInt("book_edition");
			ob.bookPrice=rs.getInt("book_price");
			ob.bookPurchasedDate=rs.getDate("purchased_date");
			ob.bookCopies=rs.getInt("no_of_bks");
			ob.bookPages=rs.getInt("no_of_pgs");
			list.add(ob);	
		}
		for (BookDetails bookDetails : list) {
			System.out.println(bookDetails);
		}
		return list;
	}
		


}
