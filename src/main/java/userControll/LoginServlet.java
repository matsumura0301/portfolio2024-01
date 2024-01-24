package userControll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//文字化け対策
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
		
			//転送の準備およびメッセージの用意
			RequestDispatcher dispatcher = null;
			String message = null;
			UserDTO user = null;
			
			//リクエストデータの格納
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");


		
			//入力欄についての空文字チェック
			if(userName.equals("") || password.equals("")) {
				message = "ユーザー名とパスワードを入力してください";
				
				//空文字の場合は再度ログイン画面へ
				request.setAttribute("alert", message);
				dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
				
			}else {
				//両方入力されている場合は該当テーブルがあるかチェック
				UserControll ucl = new UserControll();
				user = ucl.getLoginUser(userName, password);
		
				if(user != null) {
					//管理者用ページの遷移
					if(user.getPosition().equals("admin")) {
						HttpSession session = request.getSession();
						session.setAttribute("user", user);
						dispatcher = request.getRequestDispatcher("/admin.jsp");
						dispatcher.forward(request, response);
					//オペレータ用ページの遷移
					}else {
						HttpSession session = request.getSession();
						session.setAttribute("user", user);
						dispatcher = request.getRequestDispatcher("/tool.jsp");	
						dispatcher.forward(request, response);
					}
				//テーブルがない場合	
				}else {
					message = "ユーザー名またはパスワードが違います";
					request.setAttribute("alert", message);
					dispatcher = request.getRequestDispatcher("/login.jsp");
					dispatcher.forward(request, response);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
