package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionDB;
import entity.Book;

public class BookModel {
	public static List<Book> getAllBook(){
		Connection conn = null;
		CallableStatement callSt = null;
		List<Book> listBook = null;
		String querysql = "select * from Book";
		try {
			conn = ConnectionDB.openConnection();
			callSt = conn.prepareCall(querysql);
			ResultSet rs = callSt.executeQuery();
			listBook = new ArrayList<Book>();
			while(rs.next()) {
				Book Book = new Book();
				Book.setBookID(rs.getInt("bookID"));
				Book.setName(rs.getString("name"));
				Book.setGenre(rs.getString("genre"));
				Book.setInformation(rs.getString("information"));
				Book.setAuthor(rs.getString("author"));
				listBook.add(Book);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(conn, callSt);
		}
		return listBook;
	}
	public static List<Book> getAllBookAdmin(){
		Connection conn = null;
		CallableStatement callSt = null;
		List<Book> listBook = null;
		String querysql = "select * from Book";
		try {
			conn = ConnectionDB.openConnection();
			callSt = conn.prepareCall(querysql);
			ResultSet rs = callSt.executeQuery();
			listBook = new ArrayList<Book>();
			while(rs.next()) {
				Book Book = new Book();
				Book.setBookID(rs.getInt("bookID"));
				Book.setName(rs.getString("name"));
				Book.setGenre(rs.getString("genre"));
				Book.setInformation(rs.getString("information"));
				Book.setAuthor(rs.getString("author"));
				Book.setTotalQuantity(rs.getInt("totalQuantity"));
				Book.setBorrowedQuantity(rs.getInt("borrowedQuantity"));
				Book.setRemainingAmount(rs.getInt("remainingAmount"));
				listBook.add(Book);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(conn, callSt);
		}
		return listBook;
	}
	public boolean insertBook(Book book) {
		Connection conn=null;
		CallableStatement callSt=null;
		boolean check = false;
		String name = book.getName();
		String author = book.getAuthor();
		String genre = book.getGenre();
		String totalQuantity = String.valueOf(book.getTotalQuantity());
		String borrowedQuantity = String.valueOf(book.getBorrowedQuantity());
		String remainingAmount = String.valueOf(book.getRemainingAmount());
		String information = book.getInformation();
		String querysql = "insert into Book values (N\'"+ name + "\',N\'" + author + "\',N\'" + genre + "\',\'" + totalQuantity + "\',\'" + borrowedQuantity + "\',\'" + remainingAmount + "\',N\'" + information + "\')";
		System.out.println(querysql);
		try {
			conn = ConnectionDB.openConnection();
			callSt = conn.prepareCall(querysql);
			check = !callSt.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnection(conn, callSt);
		}
		return check;
	}
	public boolean updateBook(Book book) {
		Connection conn=null;
		CallableStatement callSt=null;
		boolean check = false;
		String bookID = String.valueOf(book.getBookID());
		String name = book.getName();
		String author = book.getAuthor();
		String genre = book.getGenre();
		String totalQuantity = String.valueOf(book.getTotalQuantity());
		String borrowedQuantity = String.valueOf(book.getBorrowedQuantity());
		String remainingAmount = String.valueOf(book.getRemainingAmount());
		String information = book.getInformation();
		String querysql = "update Book set name = N\'"+ name + "\', author = N\'" + author + "\', genre = N\'" + genre + "\', totalQuantity = \'" + totalQuantity + "\', borrowedQuantity = \'" + borrowedQuantity + "\', remainingAmount = \'" + remainingAmount + "\',information = N\'" + information + "\' where bookID =" + bookID;
		System.out.println(querysql);
		try {
			conn = ConnectionDB.openConnection();
			callSt = conn.prepareCall(querysql);
			check = !callSt.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnection(conn, callSt);
		}
		return check;
	}
	
	public Book getBookById(int bookID){
		Connection conn = null;
		CallableStatement callSt = null;
		Book Book = new Book();
		String querysql = "select * from Book where bookID=" + String.valueOf(bookID);
		try {
			conn = ConnectionDB.openConnection();
			callSt = conn.prepareCall(querysql);
			ResultSet rs = callSt.executeQuery();
			if (rs.next()) {				
				Book.setBookID(rs.getInt("bookID"));
				Book.setName(rs.getString("name"));
				Book.setGenre(rs.getString("genre"));
				Book.setInformation(rs.getString("information"));
				Book.setAuthor(rs.getString("author"));
				Book.setTotalQuantity(rs.getInt("totalQuantity"));
				Book.setBorrowedQuantity(rs.getInt("borrowedQuantity"));
				Book.setRemainingAmount(rs.getInt("remainingAmount"));				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnection(conn, callSt);
		}
		return Book;
	}
	
	public boolean deleteBook(int bookID) {
		Connection conn = null;
		CallableStatement callSt = null;
		boolean check = false;
		try {
			conn = ConnectionDB.openConnection();
			String querysql = "delete from Book where bookID =" + String.valueOf(bookID);							
			callSt = conn.prepareCall(querysql);
			check = !callSt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnection(conn, callSt);
		}
		return check;
	}
	public boolean borrowBook(int bookID) {
		Connection conn = null;
		CallableStatement callSt = null;
		boolean check = false;
		try {
			conn = ConnectionDB.openConnection();
			String querysql = "update book set borrowedQuantity = borrowedQuantity + 1, remainingAmount = remainingAmount - 1 where bookID =" + String.valueOf(bookID);				
			callSt = conn.prepareCall(querysql);
			check = !callSt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnection(conn, callSt);
		}
		return check;
	}
	public boolean returnBook(int bookID) {
		Connection conn = null;
		CallableStatement callSt = null;
		boolean check = false;
		try {
			conn = ConnectionDB.openConnection();
			String querysql = "update book set borrowedQuantity = borrowedQuantity - 1, remainingAmount = remainingAmount + 1 where bookID =" + String.valueOf(bookID);				
			callSt = conn.prepareCall(querysql);
			check = !callSt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnection(conn, callSt);
		}
		return check;
	}
}
