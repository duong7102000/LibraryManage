package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import model.BookModel;
import model.BorrowModel;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action.equals("GetAll")) {
			List<Book> lisBook = BookModel.getAllBook();
			String userID = request.getParameter("UserID");
			request.setAttribute("UserID", userID);
			request.setAttribute("lisBook", lisBook);
			request.getRequestDispatcher("view/listBook.jsp").forward(request, response);
		}
		else if(action.equals("GetAllAdmin")) {
			List<Book> lisBook = BookModel.getAllBookAdmin();
			String userID = request.getParameter("UserID");
			request.setAttribute("UserID", userID);
			request.setAttribute("lisBook", lisBook);
			request.getRequestDispatcher("view/listBookAdmin.jsp").forward(request, response);
		}
		else if(action.equals("Create")) {
			Book bookNew = new Book();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			String UserID = request.getParameter("UserID");
			bookNew.setName(request.getParameter("bookName"));
			bookNew.setAuthor(request.getParameter("author"));
			bookNew.setGenre(request.getParameter("genre"));
			String totalQuantity = request.getParameter("totalQuantity");
			bookNew.setTotalQuantity(Integer.parseInt(totalQuantity));
			String borrowedQuantity = request.getParameter("borrowedQuantity");
			bookNew.setBorrowedQuantity(Integer.parseInt(borrowedQuantity));
			String remainingAmount = request.getParameter("remainingAmount");
			bookNew.setRemainingAmount(Integer.parseInt(remainingAmount));
			bookNew.setInformation(request.getParameter("information"));
			BookModel bookModel = new BookModel();
			boolean check = bookModel.insertBook(bookNew);
			if(check) {
				getAllBook(request, response, bookModel, UserID);
			}else {
				request.setAttribute("UserID", UserID);
				request.getRequestDispatcher("view/insertError.jsp").forward(request, response);
			}
		}
		else if(action.equals("getBookById")) {
			int bookID = Integer.parseInt(request.getParameter("BookID"));
			String UserID = request.getParameter("UserID");
			BookModel bookModel = new BookModel();
			Book bookUpdate = bookModel.getBookById(bookID);
			request.setAttribute("UserID", UserID);
			request.setAttribute("bookUpdate", bookUpdate);
			request.getRequestDispatcher("view/updateBookAdmin.jsp").forward(request, response);
		}
		else if(action.equals("Update")) {
			Book bookNew = new Book();
			//Thuc hien cap nhat thong tin danh muc
			//-Lay thong tin danh muc can cap nhat trong request
			String UserID = request.getParameter("UserID");
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			bookNew.setBookID(Integer.parseInt(request.getParameter("bookID")));
			bookNew.setName(request.getParameter("bookName"));
			bookNew.setAuthor(request.getParameter("author"));
			bookNew.setGenre(request.getParameter("genre"));
			String totalQuantity = request.getParameter("totalQuantity");
			bookNew.setTotalQuantity(Integer.parseInt(totalQuantity));
			String borrowedQuantity = request.getParameter("borrowedQuantity");
			bookNew.setBorrowedQuantity(Integer.parseInt(borrowedQuantity));
			String remainingAmount = request.getParameter("remainingAmount");
			bookNew.setRemainingAmount(Integer.parseInt(remainingAmount));
			bookNew.setInformation(request.getParameter("information"));
			BookModel bookModel = new BookModel();
			boolean check = bookModel.updateBook(bookNew);
			if(check) {
				getAllBook(request, response, bookModel, UserID);
			}else {
				request.getRequestDispatcher("view/updateEror.jsp").forward(request, response);
			}
		}
		else if(action.equals("Delete")) {
			int bookID = Integer.parseInt(request.getParameter("BookID"));
			String UserID = request.getParameter("UserID");
			BookModel bookModel = new BookModel();
			Book book = bookModel.getBookById(bookID);
			if(book.getBorrowedQuantity()==0) {
				BorrowModel brModel = new BorrowModel();
				brModel.deleteBorrow(bookID);
			}
			boolean check = bookModel.deleteBook(bookID);
			if(check) {
				getAllBook(request, response, bookModel, UserID);
			}else {
				List<Book> lisBook = BookModel.getAllBookAdmin();
				request.setAttribute("UserID", UserID);
				request.setAttribute("lisBook", lisBook);
				request.getRequestDispatcher("view/deleteError.jsp").forward(request, response);
			}
		}
		else if(action.equals("newBook")) {
			String UserID = request.getParameter("UserID");
			request.setAttribute("UserID", UserID);
			request.getRequestDispatcher("view/newBook.jsp").forward(request, response);
		}
	}
	public void getAllBook(HttpServletRequest request, HttpServletResponse response, BookModel bookModel, String UserID) throws ServletException, IOException {
		List<Book> lisBook = BookModel.getAllBookAdmin();
		request.setAttribute("UserID", UserID);
		request.setAttribute("lisBook", lisBook);
		request.getRequestDispatcher("view/listBookAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
//
}
