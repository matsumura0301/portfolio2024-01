package databaseControll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateSentenceSearchServlet
 */
@WebServlet("/UpdateSentenceSearchServlet")
public class UpdateSentenceSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSentenceSearchServlet() {
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
			DatabaseDTO data = null;
			
			//リクエストデータの格納
			int sentenceId = Integer.parseInt(request.getParameter("sentenceId"));

			//入力された名前と一致したデータをオブジェクトへ
			DatabaseControll dcl = new DatabaseControll();
			data = dcl.getData(sentenceId);
				
			if(data != null) {
				//上記のオブジェクトをセッションスコープに入れてユーザー情報変更画面に遷移
				HttpSession session = request.getSession();
				session.setAttribute("getData", data);
				dispatcher = request.getRequestDispatcher("/updateSentence.jsp");
				dispatcher.forward(request, response);
			}else {
				message = "該当するユーザーが見つかりません";
				request.setAttribute("alert", message);
				dispatcher = request.getRequestDispatcher("/databaseManagement.jsp");
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
