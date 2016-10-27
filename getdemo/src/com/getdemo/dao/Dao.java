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
	 * ��ȡ���ݿ�����
	 * 
	 * @return Connection ����
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
	 * ��ҳ��ѯ������Ʒ��Ϣ
	 * 
	 * @param page
	 *            ҳ��
	 * @return List<Product>
	 */
	public List<Demo> find(int page, String keyword, String tag) {
		List<Demo> list = new ArrayList<Demo>();
		Connection conn = getConnection();
		String sql = "select * from list WHERE `Describe` LIKE '%" + keyword + "%' order by id desc limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page - 1) * Demo.PAGE_SIZE);
			ps.setInt(2, Demo.PAGE_SIZE);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Demo p = new Demo();
				p.setType(rs.getString("Type"));
				p.setName(rs.getString("Name"));
				p.setDescribe(rs.getString("Describe"));
				p.setDownCount(rs.getInt("DownCount"));

				if (tag.equals("��������")) {
					p.setDownName(rs.getString("DownURL"));
				} else {
					p.setDownName("recharge��jsp");
				}

				p.setUpdateTime(rs.getString("UpdateTime"));
				p.setAuthor(rs.getString("Author"));
				p.setDownOK(tag);
				list.add(p);
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ��ѯ�ܼ�¼��
	 * 
	 * @return �ܼ�¼��
	 */
	public int findCount(String keyword) {
		int count = 0;
		Connection conn = getConnection();
		String sql = "select count(*) from list WHERE `Function` LIKE '%" + keyword + "%'";
		try {
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt(1); // ���ܼ�¼����ֵ
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count; // �����ܼ�¼��
	}

	/**
	 * 
	 * ע��
	 * 
	 * @param user
	 */
	public static void register(User user) {

		Connection conn = getConnection();
		String sql = "INSERT INTO user (Email,PWD,VerCode,DownOK,Time) VALUES ('" + user.getEmail() + "','','"
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
	 * �������
	 * 
	 * @return ����
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
	 * �����֤��
	 * 
	 * @return ��֤��
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

		return vercode; // ������֤��
	}

	/**
	 * 
	 * ��������
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
	 * �����Ƿ����
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
				count = rs.getInt(1); // ���ܼ�¼����ֵ
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
	 * ������֤��
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
	 * �Ƿ��ֵ�û�
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
	 * �ϴ�Demo
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
