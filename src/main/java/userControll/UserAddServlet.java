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
 * Servlet implementation class UserAddServlet
 */
@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddServlet() {
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
			UserDTO user = null;
			
			//リクエストデータの格納
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String position = request.getParameter("position");

				//登録
				UserControll ucl = new UserControll();
				ucl.addUser(user_id,userName,password,position);
				
				//登録したデータをオブジェクトに格納
				user = ucl.getLoginUser(userName, password);
				
				//上記のオブジェクトをセッションスコープに入れてユーザー管理画面に遷移
				HttpSession session = request.getSession();
				session.setAttribute("userAdd", user);
				dispatcher = request.getRequestDispatcher("/userManagement.jsp");
				dispatcher.forward(request, response);

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
