package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//yユーザー登録画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp");
		dispatcher.forward(request, response);
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String newuser = request.getParameter("newuser");
		String newpw = request.getParameter("newpw");
		
		//登録処理
		if(newuser.length() != 0 && newpw.length() != 0) {
			ServletContext application = this.getServletContext();
			Map<String, String> userMap = (Map<String, String>) application.getAttribute("userMap");
		
		
		//ユーザーリストがアプリケーションスコープに存在しなければ、新規でインスタンスを作成
		
		if(userMap == null) {
			userMap = new HashMap<String, String>();
		}
		
		//これから登録するユーザー名がすでに登録済みか調べる。
		//登録されていなければ、登録処理を行う。
		
		if(userMap.containsKey(newuser)) {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("message", "そのユーザーは既に登録されています。");
		} else {
			//新規ユーザーを追加したユーザーリストを、アプリケーションスコープに再登録
			userMap.put(newuser, newpw);
			application.setAttribute("userMap", userMap);
			
			//登録完了メッセージをリクエストスコープに保存
			request.setAttribute("message", "登録が完了しました。");
		} 
		}else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("message", "ユーザー名、パスワードは必須項目です。");
		}
		
		//フォワード処理		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp");
		dispatcher.forward(request, response);
			}
	}


