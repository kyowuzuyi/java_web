package model;

import java.io.Serializable;

public class Article implements Serializable {
	private int id; // ID
	private String userName; // ユーザー名
	private String text; // 記事内容

	public Article() {}
	public Article(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
	public Article(int id, String userName, String text) {
		this.id = id;
		this.userName = userName;
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getText() {
		return text;
	}
}
