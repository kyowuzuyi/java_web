package model;

import java.util.ArrayList;
import java.util.List;

import dao.ArticleDAO;

public class GetArticleListLogic {
	List<Article> GetMeg;
		public GetArticleListLogic(){}
		public void execute(){
			ArticleDAO MysqlMeg = new ArticleDAO();
			GetMeg = new ArrayList<Article>();
			GetMeg = MysqlMeg.findAll();
		}
		public List<Article> GetList(){
			return GetMeg;
		}
}
