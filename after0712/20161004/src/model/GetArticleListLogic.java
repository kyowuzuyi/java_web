package model;

import java.util.List;

import dao.ArticleDAO;

public class GetArticleListLogic {
	public List<Article> execute() {
		ArticleDAO dao = new ArticleDAO();
		List<Article> articleList = dao.findAll();
		return articleList;
	}
}
