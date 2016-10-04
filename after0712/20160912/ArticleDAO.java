package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Article;

public class ArticleDAO {
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=utf8";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public List<Article> findAll() {
		Connection conn = null;
		List<Article> articleList = new ArrayList<Article>();

		try {
			// JDBCドライバを読み込み
			Class.forName(DRIVER_NAME);

			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			// SELECT文を準備
			String sql = "select id,name,text from article order by id desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SELECT文を実行し、結果表(ResultSet)を取得
			ResultSet rs = pStmt.executeQuery();

			// SELECT文の実行結果をArrayListに格納
			while (rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Article article = new Article(id, userName, text);
				articleList.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return articleList;
	}

	public boolean create(Article article) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			// INSERT文を準備
			String sql = "insert into article(name,text) values(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// INSERT文中の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, article.getUserName());
			pStmt.setString(2, article.getText());

			// INSERT文を実行
			int result = pStmt.executeUpdate();

			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			// データベース切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
}
