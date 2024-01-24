package userControll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserControll extends AutomailDAO{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;

	//ログインの際に入力と合致したユーザーのデータを取得するメソッド
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
	public void addUser(int user_id,String userName,String password,String position) {
		String sql ="INSERT INTO user VALUES(?,?,?,?);";

		try {
			
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, user_id);
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
	//ユーザーのパスワードを変更するメソッド
	//public void updateUserPassword() {
		//String sql = "UPDATE user SET ";
	//}
}