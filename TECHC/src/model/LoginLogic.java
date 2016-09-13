package model;

public class LoginLogic {
	public LoginLogic(){}
	public boolean execute(User user) {
		// 登録処理（サンプルでは登録処理を行わない）
		String temp = user.getPass();
		String pass = "1234";
		if(temp.equals(pass)){
		return true;
		}else{
			return false;
		}
	}
}
