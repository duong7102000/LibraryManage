package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import entity.Borrow;
import entity.Calendar;
import model.BookModel;
import model.BorrowModel;

/**
 * Servlet implementation class BorrowController
 */
@WebServlet("/BorrowController")
public class BorrowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		BorrowModel brModel = new BorrowModel();
		BookModel bookModel = new BookModel();
		Calendar calendar = new Calendar();
		if(action.equals("borrowByID")) {
			int bookID = Integer.parseInt(request.getParameter("BookID"));
			System.out.println(bookID);
			boolean check = bookModel.borrowBook(bookID);
			int userID = Integer.parseInt(request.getParameter("UserID"));
			if(check) {
				Borrow borrowNew = new Borrow();
				System.out.println(userID);
				borrowNew.setBorrowerID(userID);
				borrowNew.setBookID(bookID);
				borrowNew.setReturned(false);
				borrowNew.setBorrowDate(calendar.getDate());
				boolean check1 = !brModel.insertBorrow(borrowNew);
				if(check1) {
					List<Book> lisBook = bookModel.getAllBook();
					request.setAttribute("UserID", userID);
					request.setAttribute("lisBook", lisBook);
					request.getRequestDispatcher("view/borrowError.jsp").forward(request, response);
				}
				else {
					List<Book> lisBook = bookModel.getAllBook();
					request.setAttribute("UserID", userID);
					request.setAttribute("lisBook", lisBook);
					request.getRequestDispatcher("view/listBook.jsp").forward(request, response);
				}
			}
			else {
				List<Book> lisBook = bookModel.getAllBook();
				request.setAttribute("UserID", userID);
				request.setAttribute("lisBook", lisBook);
				request.getRequestDispatcher("view/borrowError.jsp").forward(request, response);}
		}
		if(action.equals("returnBook")) {
			String AdminID = request.getParameter("AdminID");
			String borrowID = request.getParameter("BorrowID");
			int bookID = Integer.parseInt(request.getParameter("BookID"));
			int userID = Integer.parseInt(request.getParameter("UserID"));
			Borrow br = brModel.getBorrowByID(Integer.parseInt(borrowID));
			if(!br.isReturned()) {
			boolean check = brModel.returnBook(borrowID, AdminID);
			boolean check1 = bookModel.returnBook(bookID);
			if(check && check1) {
				request.setAttribute("AdminID", AdminID);
				List<Borrow> listBorrow = brModel.getBorrowByBorrowerID(userID);
				request.setAttribute("listBorrow", listBorrow);
				request.getRequestDispatcher("view/listBorrowAdmin.jsp").forward(request, response);
			}
			}else {
				request.setAttribute("AdminID", AdminID);
				List<Borrow> listBorrow = brModel.getBorrowByBorrowerID(userID);
				request.setAttribute("listBorrow", listBorrow);
				request.getRequestDispatcher("view/listBorrowAdmin.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
