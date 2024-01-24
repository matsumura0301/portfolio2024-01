package userControll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
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
			int affectedRows = 0;
			String message = null;
			RequestDispatcher dispatcher = null;
			
			//リクエストデータの格納
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");

				//削除
				UserControll ucl = new UserControll();
				affectedRows = ucl.deleteUser(userName,password);
				
				if(affectedRows > 0) {
					message = (userName + "を削除しました。");
				}else {
					message = "該当データの削除に失敗しました";
				}	
				//メッセージをリクエストオブジェクトに入れて画面遷移
				request.setAttribute("alert", message);
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
