package model;

import dao.ArticleDAO;

public class PostArticleLogic {
	public void execute(Article article) {
		ArticleDAO dao = new ArticleDAO();
		dao.create(article);
	}
}
