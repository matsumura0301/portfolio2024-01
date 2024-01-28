package userControll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
			
			//リクエストデータの格納
	        String userName = request.getParameter("userName");
	        String password = request.getParameter("password");
	        String position = request.getParameter("position");

				//入力された名前と一致したデータをオブジェクトへ
				UserControll ucl = new UserControll();
				int updateRows = ucl.updateUser(userName,password,position);
				
				//成否をメッセージで通知
	            if (updateRows > 0) {
	            	message = "変更しました";
					request.setAttribute("alert", message);
					dispatcher = request.getRequestDispatcher("/updateUser.jsp");
					dispatcher.forward(request, response);
	            } else {
	               message = "変更に失敗しました";
	               request.setAttribute("alert", message);
	               dispatcher = request.getRequestDispatcher("/updateUser.jsp");
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
