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
 * Servlet implementation class UpdateUserSearchServlet
 */
@WebServlet("/UpdateUserSearchServlet")
public class UpdateUserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserSearchServlet() {
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

				//入力された名前と一致したデータをオブジェクトへ
				UserControll ucl = new UserControll();
				user = ucl.getUser(userName);
				
				if(user != null) {
					//上記のオブジェクトをセッションスコープに入れてユーザー情報変更画面に遷移
					HttpSession session = request.getSession();
					session.setAttribute("getUser", user);
					dispatcher = request.getRequestDispatcher("/updateUser.jsp");
					dispatcher.forward(request, response);
				}else {
					message = "ユーザー名またはパスワードが違います";
					request.setAttribute("alert", message);
					dispatcher = request.getRequestDispatcher("/userManagement.jsp");
					dispatcher.forward(request, response);
				}

		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
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
