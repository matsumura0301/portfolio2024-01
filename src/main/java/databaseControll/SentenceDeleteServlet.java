package databaseControll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SentenceDeleteServlet
 */
@WebServlet("/SentenceDeleteServlet")
public class SentenceDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SentenceDeleteServlet() {
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
			String deleteMessage = null;
			RequestDispatcher dispatcher = null;
			
			//リクエストデータの格納
	        int sentenceId = Integer.parseInt(request.getParameter("sentenceId"));
	        String sentenceName = request.getParameter("sentenceName");

			//削除
			DatabaseControll dcl = new DatabaseControll();
			affectedRows = dcl.deleteSetence(sentenceId,sentenceName);
			
			//削除成功
			if(affectedRows > 0) {
			deleteMessage = (sentenceName + "を削除しました。");
			request.setAttribute("deleteAlert", deleteMessage);
			dispatcher = request.getRequestDispatcher("/databaseManagement.jsp");
			dispatcher.forward(request, response);
			//削除失敗
			}else {
			deleteMessage = "該当データの削除に失敗しました";
			request.setAttribute("deleteAlert", deleteMessage);
			dispatcher = request.getRequestDispatcher("/databaseManagement.jsp");
			dispatcher.forward(request, response);
			}
			
			//メッセージをリクエストオブジェクトに入れて画面遷移

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
