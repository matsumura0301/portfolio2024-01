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
 * Servlet implementation class SentenceAddServlet
 */
@WebServlet("/SentenceAddServlet")
public class SentenceAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SentenceAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//文字化け対策
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
		
			//転送の準備およびメッセージの用意
			RequestDispatcher dispatcher = null;
			DatabaseDTO data = null;
			
			//リクエストデータの格納
	        int sentenceId = Integer.parseInt(request.getParameter("sentenceId"));
	        String sentenceName = request.getParameter("sentenceName");
	        String sentenceMain = request.getParameter("sentenceMain");
	        int sentenceLine = Integer.parseInt(request.getParameter("sentenceLine"));
	        String sentenceKind = request.getParameter("sentenceKind");
	        String sentenceTemp = request.getParameter("sentenceTemp");

				//登録
			DatabaseControll dcl = new DatabaseControll();
			dcl.addSentence(sentenceId,sentenceName,sentenceMain,sentenceLine,sentenceKind,sentenceTemp);
				
			//登録したデータをオブジェクトに格納
			data = dcl.getData(sentenceId, sentenceName);
				
			//上記のオブジェクトをセッションスコープに入れてユーザー管理画面に遷移
				HttpSession session = request.getSession();
				session.setAttribute("dataAdd", data);
				dispatcher = request.getRequestDispatcher("/databaseManagement.jsp");
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
