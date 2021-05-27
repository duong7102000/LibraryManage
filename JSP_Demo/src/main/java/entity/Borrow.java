package entity;

public class Borrow {
	private int borrowID;
	private String borrowDate;
	private int borrowerID;
	private boolean isReturned;
	private int librarianID;
	private int bookID;
	private String returnDate;
	private String bookName;
	private String adminName;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBorrowID() {
		return borrowID;
	}
	public void setBorrowID(int borrowID) {
		this.borrowID = borrowID;
	}
	public String getBorrowDate() {
		return borrowDate;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}
	public int getBorrowerID() {
		return borrowerID;
	}
	public void setBorrowerID(int borrowerID) {
		this.borrowerID = borrowerID;
	}
	public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	public int getLibrarianID() {
		return librarianID;
	}
	public void setLibrarianID(int librarianID) {
		this.librarianID = librarianID;
	}
	public Borrow() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
