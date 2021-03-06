package com.chainsys.libraryapp.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.chainsys.libraryapp.LibaryModel.BookDetails;
import com.chainsys.libraryapp.util.Connectionutil;
import com.chainsys.libraryapp.dao.BookDetailsDAO;
import com.chainsys.libraryapp.exception.DbException;



public class BookDetailsDAOImp implements BookDetailsDAO{
	

	public void addNewBook(BookDetails bookdetails) throws DbException {
		String sql = "insert into books(book_name,book_cat,book_author,book_edition,no_of_bks,no_of_pgs,purchased_date,book_price,book_id)values  (?,?,?,?,?,?,?,?,id_seq.nextval)";
		try(Connection con=Connectionutil.getConnection();PreparedStatement stmt=con.prepareStatement(sql);)
		{
		stmt.setString(1,bookdetails.getBookName());
	    stmt.setString(2, bookdetails.getBookCategory());
	    stmt.setString(3, bookdetails.getBookAutherName());
	    stmt.setInt(4, bookdetails.getBookEdition());
	    stmt.setInt(5, bookdetails.getBookCopies());
	    stmt.setInt(6, bookdetails.getBookPages());
	    stmt.setDate(7,bookdetails.getBookPurchasedDate() );
	    stmt.setInt(8, bookdetails.getBookPrice());
	    stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new DbException("Unable to Insert books");
		}
	}


	public void updateBookCopies(int bookId,int bookCopies) throws DbException {
		
		//String sql=  "update books set no_of_bks=(no_of_bks+?) where book_name=? and book_edition=?";
		String sql=  "update books set no_of_bks=(no_of_bks+"+bookCopies+") where book_id="+bookId;
		try(Connection con=Connectionutil.getConnection();
				Statement st = con.createStatement();)
		{
		st.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new DbException("Unable to update");
		}
	}

	public BookDetails displayBook(int bookId) throws DbException {
		
		String sql="select * from books where book_id=?";
		BookDetails ob=null;
		try(Connection con=Connectionutil.getConnection();
		PreparedStatement stmt= con.prepareStatement(sql);)
		{
		stmt.setInt(1, bookId);
		
		try(ResultSet rs = stmt.executeQuery();)
		{
		
		if(rs.next())
		{
			ob = new BookDetails();
			ob.setBookId(rs.getInt("book_id"));
			ob.setBookName(rs.getString("book_name"));
			ob.setBookCategory(rs.getString("book_cat"));
			ob.setBookAutherName(rs.getString("book_author"));
			ob.setBookEdition(rs.getInt("book_edition"));
			ob.setBookPrice(rs.getInt("book_price"));
			ob.setBookPurchasedDate(rs.getDate("purchased_date"));
			ob.setBookCopies(rs.getInt("no_of_bks"));
			ob.setBookPages(rs.getInt("no_of_pgs"));
		}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new DbException("Unable to display");
		}
		
		return ob;
	}

	public ArrayList<BookDetails> displayAllBooks() throws DbException {
		String sql ="select * from books";
		ArrayList<BookDetails> list= new ArrayList<BookDetails>();
		try(Connection con=Connectionutil.getConnection();
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();)
		{
		
		while(rs.next())
		{
			BookDetails ob= new BookDetails();
			ob.setBookId(rs.getInt("book_id"));
			ob.setBookName(rs.getString("book_name"));
			ob.setBookCategory(rs.getString("book_cat"));
			ob.setBookAutherName(rs.getString("book_author"));
			ob.setBookEdition(rs.getInt("book_edition"));
			ob.setBookPrice(rs.getInt("book_price"));
			ob.setBookPurchasedDate(rs.getDate("purchased_date"));
			ob.setBookCopies(rs.getInt("no_of_bks"));
			ob.setBookPages(rs.getInt("no_of_pgs"));
			list.add(ob);	
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new DbException("unable to display");
		}
		return list;
	}


	@Override
	public ArrayList<BookDetails> searchByName(String bookName) throws DbException {
		String sql="select * from books where lower(book_name)like lower('%"+bookName+"%')";
		ArrayList<BookDetails> list= new ArrayList<BookDetails>();
		try(Connection con=Connectionutil.getConnection();
				Statement st = con.createStatement();ResultSet rs = st.executeQuery(sql);)
		{
		
			while(rs.next())
			{
				BookDetails ob= new BookDetails();
				ob.setBookId(rs.getInt("book_id"));
				ob.setBookName(rs.getString("book_name"));
				ob.setBookCategory(rs.getString("book_cat"));
				ob.setBookAutherName(rs.getString("book_author"));
				ob.setBookEdition(rs.getInt("book_edition"));
				ob.setBookPrice(rs.getInt("book_price"));
				ob.setBookPurchasedDate(rs.getDate("purchased_date"));
				ob.setBookCopies(rs.getInt("no_of_bks"));
				ob.setBookPages(rs.getInt("no_of_pgs"));
				list.add(ob);
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new DbException("unable to display");
		}
		return list;
	}
		


}
