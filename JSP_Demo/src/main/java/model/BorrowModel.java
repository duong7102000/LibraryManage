package model;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Borrow;
import entity.Calendar;
import util.ConnectionDB;

public class BorrowModel {
	public List<Borrow> getBorrowByBorrowerID(int borrowerID){
		Connection conn = null;
		CallableStatement callSt = null;
		List<Borrow> listBorrow = null;
		String querysql = "select Book.name, Borrow.borrowDate, Borrow.returnDate, UserList.name as adminName, borrowID, librarianID, isReturned, Book.bookID, borrowerID from Book \r\n"
				+ "inner join Borrow on Book.bookID = Borrow.bookID\r\n"
				+ "inner join UserList on Borrow.librarianID = UserList.userID\r\n"
				+ "where Borrow.borrowerID = " + String.valueOf(borrowerID);
		System.out.println(querysql);
		try {
			conn = ConnectionDB.openConnection();
			callSt = conn.prepareCall(querysql);
			ResultSet rs = callSt.executeQuery();
			listBorrow = new ArrayList<Borrow>();
			while(rs.next()) {
				Borrow borrow = new Borrow();
				borrow.setBorrowID(rs.getInt("borrowID"));
				borrow.setBorrowDate(rs.getString("borrowDate"));
				borrow.setBorrowerID(rs.getInt("borrowerID"));
				borrow.setLibrarianID(rs.getInt("librarianID"));
				borrow.setReturned(rs.getBoolean("isReturned"));
				borrow.setReturnDate(rs.getString("returnDate"));
				borrow.setBookID(rs.getInt("bookID"));
				borrow.setBookName(rs.getString("name"));
				borrow.setAdminName(rs.getString("adminName"));
				listBorrow.add(borrow);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(conn, callSt);
		}
		return listBorrow;
	}
	public Borrow getBorrowByID(int borrowID) {
		Connection conn = null;
		CallableStatement callSt = null;
		String querysql = "select * from Borrow where borrowID = " + String.valueOf(borrowID);
		Borrow borrow = new Borrow();
		try {
			conn = ConnectionDB.openConnection();
			callSt = conn.prepareCall(querysql);
			ResultSet rs = callSt.executeQuery();
			if(rs.next()) {
				borrow.setBorrowID(rs.getInt("borrowID"));
				borrow.setBorrowDate(rs.getString("borrowDate"));
				borrow.setBorrowerID(rs.getInt("borrowerID"));
				borrow.setLibrarianID(rs.getInt("librarianID"));
				borrow.setReturned(rs.getBoolean("isReturned"));
				borrow.setReturnDate(rs.getString("returnDate"));
				borrow.setBookID(rs.getInt("bookID"));
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(conn, callSt);
		}
		return borrow;
	}
	public static boolean insertBorrow(Borrow newBorrow) {
		Connection conn=null;
		CallableStatement callSt=null;
		boolean check = false;
		String borrowDate = newBorrow.getBorrowDate();
		String borrowerID = String.valueOf(newBorrow.getBorrowerID());
		boolean isReturned = newBorrow.isReturned();
		String returned = "0";
		if(isReturned) returned = "1";
		String librarianID = String.valueOf(newBorrow.getLibrarianID());
		String returnDate = newBorrow.getReturnDate();
		String bookID = String.valueOf(newBorrow.getBookID());
		String querysql = "insert into Borrow values (\'"+ borrowDate + "\',\'" + borrowerID + "\',\'" + returned + "\',32,null,\'" + bookID + "\')";
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
	public boolean returnBook(String borrowID, String librarianID) {
		Connection conn=null;
		CallableStatement callSt=null;
		boolean check = false;
		Calendar calendar = new Calendar();
		String date = calendar.getDate();
		String querysql = "update Borrow set returnDate = \'" + date +"\', librarianID = " + librarianID + ", isReturned = 1 where borrowID = " + borrowID;
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
	public boolean deleteBorrow(int bookID) {
		Connection conn=null;
		CallableStatement callSt=null;
		boolean check = false;
		String querysql = "delete from Borrow where bookID = " + String.valueOf(bookID);
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
}
