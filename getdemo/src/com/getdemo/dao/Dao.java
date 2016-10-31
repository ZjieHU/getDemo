package com.getdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.getdemo.bean.Demo;
import com.getdemo.bean.User;

public class Dao {
	
	private static Connection conn;
	
	/**
	 * 锟斤拷取锟斤拷锟捷匡拷锟斤拷锟斤拷
	 * 
	 * @return Connection 锟斤拷锟斤拷
	 */
	public static Connection getConnection() {
		conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/getdemo";
			String user = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection() {
		try {
			if(!conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 锟斤拷页锟斤拷询锟斤拷锟斤拷锟斤拷品锟斤拷息
	 * 
	 * @param page
	 *            页锟斤拷
	 * @return List<Product>
	 */
	public List<Demo> find(int page, String keyword, String tag) {
		List<Demo> list = new ArrayList<Demo>();
		
		Connection conn = getConnection();
		
		String sql = new String();
		
		if(keyword == null) {
			sql = "SELECT * FROM list ORDER BY DownCount DESC";
		}else {
			sql = "SELECT * FROM list WHERE `Name` LIKE '%"+keyword+"%' ORDER BY DownCount DESC";
		}
		
		try {
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Demo demo = new Demo();
				
				demo.setAuthor(rs.getString("Author"));
				
				String desc = rs.getString("Describe");
				if(desc.length() > 180) {
					demo.setDescribe(desc.substring(0, 100)+"...");
				}else {
					demo.setDescribe(desc);
				}
				
				demo.setDownCount(rs.getInt("DownCount"));
				
				demo.setDownName(rs.getString("DownName"));
				
				demo.setFunction(rs.getString("Function"));
				
				demo.setName(rs.getString("Name"));
				
				demo.setPrice(rs.getInt("price"));
				
				demo.setTime(rs.getString("Time"));
				
				demo.setType(rs.getString("Type"));
				
				demo.setUpdateTime(rs.getString("UpdateTime"));
				
				demo.setId(rs.getInt("id"));
				
				demo.setPrictureurl(rs.getString("pictureurl"));
				
				list.add(demo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * 锟斤拷询锟杰硷拷录锟斤拷
	 * 
	 * @return 锟杰硷拷录锟斤拷
	 */
	public int findCount(String keyword) {
		int count = 0;
		Connection conn = getConnection();
		String sql = "select count(*) from list WHERE `Function` LIKE '%" + keyword + "%'";
		try {
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt(1); // 锟斤拷锟杰硷拷录锟斤拷锟斤拷值
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count; // 锟斤拷锟斤拷锟杰硷拷录锟斤拷
	}

	/**
	 * 
	 * 注锟斤拷
	 * 
	 * @param user
	 */
	public static void register(User user) {

		Connection conn = getConnection();
		String sql = "INSERT INTO user (Email,PWD,VerCode,DownOK,Time) VALUES ('" + user.getEmail() + "','"+user.getPwd()+"','"
				+ user.getVercode() + "','" + user.getDownOK() + "','" + user.getTime() + "')";

		try {
			Statement sta = conn.createStatement();
			sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟�
	 * 
	 * @return 锟斤拷锟斤拷
	 */
	public static String getPWD(String email) {

		String pwd = null;
		Connection conn = getConnection();
		String sql = "SELECT PWD FROM `user` WHERE Email = '" + email + "'";
		try {
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				pwd = rs.getString("PWD");

			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pwd;
	}

	/**
	 * 锟斤拷锟斤拷锟街わ拷锟�
	 * 
	 * @return 锟斤拷证锟斤拷
	 */
	public static String getVerCode(String email) {

		String vercode = null;
		Connection conn = getConnection();
		String sql = "SELECT VerCode FROM `user` WHERE Email = '" + email + "'";
		try {
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				vercode = rs.getString("VerCode");
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vercode; // 锟斤拷锟斤拷锟斤拷证锟斤拷
	}

	/**
	 * 
	 * 锟斤拷锟斤拷锟斤拷锟斤拷
	 * 
	 * @param user
	 */
	public static void setPWD(String email, String pwd) {

		Connection conn = getConnection();
		String sql = "UPDATE `user` SET PWD = '" + pwd + "' WHERE Email = '" + email + "'";

		try {
			Statement sta = conn.createStatement();
			sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 锟斤拷锟斤拷锟角凤拷锟斤拷锟�
	 * 
	 * @return
	 */
	public static boolean checkEmail(String email) {
		int count = 0;
		Connection conn = getConnection();
		String sql = "SELECT COUNT(*) FROM `user` WHERE Email = '" + email + "'";
		try {
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt(1); // 锟斤拷锟杰硷拷录锟斤拷锟斤拷值
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (count >= 1) {

			return true;

		} else {

			return false;

		}

	}

	/**
	 * 
	 * 锟斤拷锟斤拷锟斤拷证锟斤拷
	 * 
	 * @param user
	 */
	public static void setVerCode(String email, String vercode) {

		Connection conn = getConnection();
		String sql = "UPDATE `user` SET VerCode = '" + vercode + "' WHERE Email = '" + email + "'";

		try {
			Statement sta = conn.createStatement();
			sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 锟角凤拷锟街碉拷没锟�
	 * 
	 * @return
	 */
	public static boolean checkDownOK(String email) {

		String downOK = null;
		Connection conn = getConnection();
		String sql = "SELECT DownOK FROM `user` WHERE Email = '" + email + "'";
		try {
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			if (rs.next()) {
				downOK = rs.getString("downOK");
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (downOK.equals("1")) {

			return true;

		} else {

			return false;

		}

	}

	/**
	 * 
	 * 锟较达拷Demo
	 * 
	 * @param user
	 */
	public static void updateDemo(Demo demo) {

		Connection conn = getConnection();
		String sql = "INSERT INTO list (Type,`Name`,`Function`,`Describe`,DownCount,DownName,UpdateTime,Author,Time) VALUES ('"
				+ demo.getType() + "','" + demo.getName() + "','" + demo.getFunction() + "','" + demo.getDescribe()
				+ "','" + demo.getDownCount() + "','" + demo.getDownName() + "','" + demo.getUpdateTime() + "','"
				+ demo.getAuthor() + "','" + demo.getTime() + "')";

		try {
			Statement sta = conn.createStatement();
			sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
