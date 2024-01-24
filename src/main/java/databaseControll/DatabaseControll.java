package databaseControll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import userControll.AutomailDAO;

public class DatabaseControll extends AutomailDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;

	//IDとタイトルで検索するメソッド
	public DatabaseDTO getData(int sentenceId,String sentenceName) {

		String sql = "SELECT * FROM csmail WHERE sentenceId=? AND sentenceName=?";

		DatabaseDTO data = null;

		try {
			//データベース接続
			conn = getConnection();

			//SELECT分の実行
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sentenceId);
			pstmt.setString(2, sentenceName);
			rset = pstmt.executeQuery();

			//該当するテーブルをオブジェクトに格納
			if(rset.next()) {
				data = new DatabaseDTO();
				data.setSentenceId(rset.getInt(1));
				data.setSentenceName(rset.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		return data;
	}
	
	//すべてのユーザーを取得しリストとして返すメソッド
	public List<DatabaseDTO> showAllsentence(){
		List<DatabaseDTO> datalist = new ArrayList<>();
		
		String sql = "SELECT * FROM csmail";
		
		try {
			//データベース接続
			conn = getConnection();

			//SELECT分の実行
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			//該当するテーブルをオブジェクトに格納
			while(rset.next()) {
				DatabaseDTO data = new DatabaseDTO();
				data.setSentenceName(rset.getString(2));
				data.setSentenceMain(rset.getString(3));
				data.setSentenceLine(rset.getString(4));
				data.setSentenceKind(rset.getString(5));
				data.setSentenceTemp(rset.getString(6));
				datalist.add(data);
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
	//データを追加するメソッド
	public void addSentence(int sentenceId,String sentenceName,String sentenceMain,int sentenceLine,String sentenceKind,String sentenceTemp) {
		String sql ="INSERT INTO csmail VALUES(?,?,?,?,?,?);";

		try {
			
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, sentenceId);
			pstmt.setString(2, sentenceName);
			pstmt.setString(3, sentenceMain);
			pstmt.setInt(4, sentenceLine);
			pstmt.setString(5, sentenceKind);
			pstmt.setString(6, sentenceTemp);
			
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
	}
	//データを削除するメソッド
	public int deleteSetence(int sentenceId,String sentenceName) {
		String sql ="DELETE FROM csmail WHERE sentenceId=? AND sentenceName=?";
		int affectedRows = 0;
		
		try {
			
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, sentenceId);
			pstmt.setString(2, sentenceName);
			
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
	//データベースのsentenceLineからランダムに1つ取得するメソッド
	public ArrayList<String> makeMail(){
		ArrayList<String> mail = new ArrayList<String>();
		String sql ="SELECT * From csmail WHERE sentenceLine = ? ORDER BY RAND() LIMIT 1;";
		
		for(int i = 1;i < 8;i++) {
			try {
			
				conn = getConnection();
			
				pstmt = conn.prepareStatement(sql);
			
				pstmt.setInt(1, i);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					String sentence = rset.getString(3);
					mail.add(sentence);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
				close(conn);
			}
		}
		return mail;
	}
}
