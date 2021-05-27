package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.*;
import model.BorrowModel;
import model.UserListModel;

/**
 * Servlet implementation class UserListController
 */
@WebServlet("/UserListController")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		UserListModel usModel = new UserListModel();
		if(action.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			List<UserList> listUs = UserListModel.getAllUser();
			boolean check = true;
			for(UserList us: listUs) {
				if(us.getUserName().equals(username) && us.getPassWord().equals(password) && !us.isRole()) {
					request.setAttribute("user", us);
					request.getRequestDispatcher("view/welcomeUser.jsp").forward(request, response);
					check = false;
					break;
				}
				else if(us.getUserName().equals(username) && us.getPassWord().equals(password) && us.isRole()) {
					request.setAttribute("user", us);
					request.getRequestDispatcher("view/welcomeAdmin.jsp").forward(request, response);
					check = false;
					break;
				}
			}
			if(check) {
				request.getRequestDispatcher("view/loginError.jsp").forward(request, response);
			}
		}
		else if(action.equals("register")) {
			request.getRequestDispatcher("view/register.jsp").forward(request, response);
		}
		else if(action.equals("Register")) {
			UserList usNew = new UserList();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			usNew.setName(name);
			usNew.setdOB(request.getParameter("dOB"));
			usNew.setAddress(address);
			usNew.setUserName(request.getParameter("userName"));
			usNew.setPassWord(request.getParameter("passWord"));
			boolean check = usModel.insertUser(usNew);
			if(check) {
				request.getRequestDispatcher("view/index.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("view/register.jsp").forward(request, response);				
			}
		}
		else if(action.equals("LogOut")) {
			request.getRequestDispatcher("view/index.jsp").forward(request, response);
		}
		else if(action.equals("Đăng nhập")) {
			request.getRequestDispatcher("view/index.jsp").forward(request, response);
		}
		else if(action.equals("AllUser")){
			List<UserList> listUs = UserListModel.getAllUser();
			String userID = request.getParameter("UserID");
			request.setAttribute("UserID", userID);
			request.setAttribute("listUs", listUs);
			request.getRequestDispatcher("view/listUser.jsp").forward(request, response);
		}
		else if(action.equals("BookBorrowed")) {
			BorrowModel borrowModel = new BorrowModel();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			int borrowerID = Integer.parseInt(request.getParameter("UserID"));
			List<Borrow> listBorrow = borrowModel.getBorrowByBorrowerID(borrowerID);
			request.setAttribute("UserID", borrowerID);
			request.setAttribute("listBorrow", listBorrow);
			request.getRequestDispatcher("view/listBorrow.jsp").forward(request, response);
		}
		else if(action.equals("ViewInfo")) {
			int userID = Integer.parseInt(request.getParameter("UserID"));
			System.out.println(userID);
			UserList us = usModel.getUserByID(userID);
			request.setAttribute("us", us);
			request.getRequestDispatcher("view/viewInfo.jsp").forward(request, response);
		}
		else if(action.equals("Đổi mật khẩu")) {
			int userID = Integer.parseInt(request.getParameter("UserID"));
			String newPass = request.getParameter("passWord");
			boolean check = usModel.changePass(userID, newPass);
			if(check) {
				UserList us = usModel.getUserByID(userID);
				request.setAttribute("us", us);
				request.getRequestDispatcher("view/viewInfo.jsp").forward(request, response);
			}
		}
		else if(action.equals("ViewInfoAdmin")) {
			int userID = Integer.parseInt(request.getParameter("UserID"));
			System.out.println(userID);
			UserList us = usModel.getUserByID(userID);
			request.setAttribute("us", us);
			request.getRequestDispatcher("view/viewInfoAdmin.jsp").forward(request, response);
		}
		else if(action.equals(" Đổi mật khẩu ")) {
			int userID = Integer.parseInt(request.getParameter("UserID"));
			String newPass = request.getParameter("passWord");
			boolean check = usModel.changePass(userID, newPass);
			if(check) {
				UserList us = usModel.getUserByID(userID);
				request.setAttribute("us", us);
				request.getRequestDispatcher("view/viewInfoAdmin.jsp").forward(request, response);
			}
		}
		else if(action.equals("ListBorrow")) {
			String AdminID = request.getParameter("AdminID");
			int UserID = Integer.parseInt(request.getParameter("UserID"));
			BorrowModel boModel = new BorrowModel();
			List<Borrow> listBorrow = boModel.getBorrowByBorrowerID(UserID);
			request.setAttribute("listBorrow", listBorrow);
			request.setAttribute("AdminID", AdminID);
			request.getRequestDispatcher("view/listBorrowAdmin.jsp").forward(request, response);
		}
		else if(action.equals("registerAdmin")) {
			String userID = request.getParameter("UserID");
			request.setAttribute("UserID", userID);
			request.getRequestDispatcher("view/registerAdmin.jsp").forward(request, response);
		}
		else if(action.equals(" Register ")) {
			String userID = request.getParameter("UserID");
			UserList usNew = new UserList();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			usNew.setName(name);
			usNew.setdOB(request.getParameter("dOB"));
			usNew.setAddress(address);
			usNew.setUserName(request.getParameter("userName"));
			usNew.setPassWord(request.getParameter("passWord"));
			boolean check = usModel.insertAdmin(usNew);
			if(check) {
				request.getRequestDispatcher("view/index.jsp").forward(request, response);
			}
			else {
				
				request.setAttribute("UserID", userID);
				request.getRequestDispatcher("view/registerAdminError.jsp").forward(request, response);				
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
