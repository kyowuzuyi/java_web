package model;

import dao.ArticleDAO;

public class PostArticleLogic {
	public PostArticleLogic(){}
	public void execute(Article article){
		ArticleDAO MysqlMeg = new ArticleDAO();
		MysqlMeg.create(article);
	}
}
