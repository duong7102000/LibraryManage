package entity;

public class Book {
	private int bookID;
	private String name;
	private String genre;
	private	int totalQuantity;
	private int borrowedQuantity;
	private int remainingAmount;
	private String information;
	private String author;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public int getBorrowedQuantity() {
		return borrowedQuantity;
	}
	public void setBorrowedQuantity(int borrowedQuantity) {
		this.borrowedQuantity = borrowedQuantity;
	}
	public int getRemainingAmount() {
		return remainingAmount;
	}
	public void setRemainingAmount(int remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
