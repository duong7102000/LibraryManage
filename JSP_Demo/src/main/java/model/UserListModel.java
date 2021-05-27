package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionDB;
import entity.UserList;

public class UserListModel {
	public static List<UserList> getAllUser(){
		Connection conn = null;
		CallableStatement callSt = null;
		List<UserList> listUs = null;
		String querysql = "select * from UserList";
		try {
			conn = ConnectionDB.openConnection();
			callSt = conn.prepareCall(querysql);
			ResultSet rs = callSt.executeQuery();
			listUs = new ArrayList<UserList>();
			while(rs.next()) {
				UserList user = new UserList();
				user.setUserID(rs.getInt("userID"));
				user.setName(rs.getString("name"));
				user.setdOB(rs.getString("dOB"));
				user.setAddress(rs.getString("address"));
				user.setRole(rs.getBoolean("role"));
				user.setUserName(rs.getString("userName"));
				user.setPassWord(rs.getString("passWord"));
				listUs.add(user);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(conn, callSt);
		}
		return listUs;
	}
	public boolean insertUser(UserList us) {
	Connection conn = null;
	CallableStatement callSt = null;
	boolean check = false;
	String name = us.getName();
	String dOB = us.getdOB();
	String address = us.getAddress();
	String userName = us.getUserName();
	String passWord = us.getPassWord();
	String querysql = "insert into UserList values (N\'"+ name + "\',\'" + dOB + "\',N\'" + address + "\'," + "\'" + userName + "\'," + "\'" + passWord + "\',0)";
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
	public boolean insertAdmin(UserList us) {
		Connection conn = null;
		CallableStatement callSt = null;
		boolean check = false;
		String name = us.getName();
		String dOB = us.getdOB();
		String address = us.getAddress();
		String userName = us.getUserName();
		String passWord = us.getPassWord();
		String querysql = "insert into UserList values (N\'"+ name + "\',\'" + dOB + "\',N\'" + address + "\'," + "\'" + userName + "\'," + "\'" + passWord + "\',1)";
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
	public UserList getUserByID(int userID) {
		Connection conn = null;
		CallableStatement callSt = null;
		UserList us = new UserList();
		String querysql = "select * from UserList where userID = " + String.valueOf(userID);
		System.out.println(querysql);
		try {
			conn = ConnectionDB.openConnection();
			callSt = conn.prepareCall(querysql);
			ResultSet rs = callSt.executeQuery();
			if (rs.next()) {
				us.setUserID(userID);
				us.setName(rs.getString("name"));
				us.setUserName(rs.getString("userName"));
				us.setdOB(rs.getString("dOB"));
				us.setAddress(rs.getString("address"));
				us.setPassWord(rs.getString("passWord"));
			}		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConnectionDB.closeConnection(conn, callSt);
		}
		return us;
	}
	public boolean changePass(int userID, String newPass) {
		Connection conn = null;
		CallableStatement callSt = null;
		boolean check = false;
		String querysql = "update UserList set passWord = \'" + newPass + "\' where userID = " + String.valueOf(userID);
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
