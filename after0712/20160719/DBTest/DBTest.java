package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Article;

/**
 * Servlet implementation class Login
 */
@WebServlet("/DBTest")
public class DBTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/BBS";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		List<Article> articleList = new ArrayList<Article>();

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			String sql = "select id,name,text from article order by id";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Article mutter = new Article(id, userName, text);
				articleList.add(mutter);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>DB接続サンプル</title>");
		out.println("</head>");
		out.println("<body>");
		for(Article article:articleList){
			out.println("<p>" + article.getUserName() + "：" + article.getText() + "</p>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
