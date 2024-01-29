package userControll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserControll extends AutomailDAO{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;

	//名前とパスワードが合致したユーザーのデータを取得するメソッド
	public UserDTO getLoginUser(String userName,String password) {

		String sql = "SELECT * FROM user WHERE userName=? AND password=?";

		UserDTO user = null;

		try {
			//データベース接続
			conn = getConnection();

			//SELECT分の実行
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			rset = pstmt.executeQuery();

			//該当するテーブルをオブジェクトに格納
			if(rset.next()) {
				user = new UserDTO();
				user.setUserName(rset.getString(2));
				user.setPassword(rset.getString(3));
				user.setPosition(rset.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		return user;
	}
	//名前が合致したユーザーのデータを取得するメソッド
	public UserDTO getUser(String userName) {

		String sql = "SELECT * FROM user WHERE userName=?";

		UserDTO user = null;

		try {
			//データベース接続
			conn = getConnection();

			//SELECT分の実行
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rset = pstmt.executeQuery();

			//該当するテーブルをオブジェクトに格納
			if(rset.next()) {
				user = new UserDTO();
				user.setUserId(rset.getInt(1));
				user.setUserName(rset.getString(2));
				user.setPassword(rset.getString(3));
				user.setPosition(rset.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		return user;
	}
	
	//すべてのユーザーを取得しリストとして返すメソッド
	public List<UserDTO> showAllUser(){
		List<UserDTO> datalist = new ArrayList<>();
		
		String sql = "SELECT * FROM user";
		
		try {
			//データベース接続
			conn = getConnection();

			//SELECT分の実行
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			//該当するテーブルをオブジェクトに格納
			while(rset.next()) {
				UserDTO user = new UserDTO();
				user.setUserName(rset.getString(2));
				user.setPassword(rset.getString(3));
				user.setPosition(rset.getString(4));
				datalist.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		return datalist;
	}
	
	//ユーザーを追加するメソッド
	public void addUser(String userName,String password,String position) {
		String sql ="INSERT INTO user VALUES(?,?,?,?);";
		String getMaxIdSql = "SELECT MAX(userId) AS maxId FROM user;";

		try {
			
			conn = getConnection();
			
	        // ユーザーIDの取得
			int userId = 0;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(getMaxIdSql);
			if (rs.next()) {
				userId = rs.getInt("maxId") + 1;
			}
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userId);
			pstmt.setString(2, userName);
			pstmt.setString(3, password);
			pstmt.setString(4, position);
			
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
	}
	
	//ユーザーを削除するメソッド
	public int deleteUser(String userName,String password) {
		String sql ="DELETE FROM user WHERE userName=? AND password=?";
		int affectedRows = 0;
		
		try {
			
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			
			affectedRows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		return affectedRows;
	}
	//ユーザーのレコードを変更するメソッド
	public int updateUser(String userName,String password,String position,int userId) {
		String sql ="UPDATE user SET userName=?, password=?, position=? WHERE userId=?";
		int updateRows = 0;
		
		try {
			
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			pstmt.setString(3, position);
			pstmt.setInt(4, userId);
			
			updateRows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		return updateRows;
	}
}