package model;

import java.util.Map;

public class LoginLogic {
	public boolean execute(User user, Map<String, String> userMap ) {
/*		if (user.getPw().equals("1234")) {
			return true;
		}
*/				
		if(userMap != null) {
			String pw = userMap.get(user.getName());
			if(user.getPw().equals(pw)) {
				return true;
			}
			} else {
				//userMapがnull（ユーザーリストが未登録）の場合はログイン失敗として処理
				return false;
			}
		
		return false;
	}
}
