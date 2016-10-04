package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Article;
import model.GetArticleListLogic;
import model.PostArticleLogic;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 記事リストを取得して、リクエストスコープに保存
		GetArticleListLogic getArticleListLogic = new GetArticleListLogic();
		List<Article> articleList = getArticleListLogic.execute();
		request.setAttribute("articleList", articleList);

		// ログインしているか確認するため
		// セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) { // ログインしていない場合
			// リダイレクト
			response.sendRedirect("/TECHC/");
		} else { // ログイン済みの場合
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		// 入力値チェック
		if (text.length() != 0 && text != null) {
			// セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");

			// 記事を記事リストに追加
			Article article = new Article(loginUser.getName(), text);
			PostArticleLogic postArticleLogic = new PostArticleLogic();
			postArticleLogic.execute(article);

		} else {
			// エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "記事が入力されていません");
		}

		// 記事リストを取得して、リクエストスコープに保存
		GetArticleListLogic getArticleListLogic = new GetArticleListLogic();
		List<Article> articleList = getArticleListLogic.execute();
		request.setAttribute("articleList", articleList);

		// メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
