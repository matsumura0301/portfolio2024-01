package databaseControll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdataSentence
 */
@WebServlet("/UpdateSentenceServlet")
public class UpdateSentenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSentenceServlet() {
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
			String updataMessage = null;
			int affectedRows = 0;
			
			//リクエストデータの格納
			int sentenceId = Integer.parseInt(request.getParameter("sentenceId"));
			String sentenceName = request.getParameter("sentenceName");
			String sentenceMain = request.getParameter("sentenceMain");
			int sentenceLine = Integer.parseInt(request.getParameter("sentenceLine"));
			String sentenceKind = request.getParameter("sentenceKind");
			String sentenceTemp = request.getParameter("sentenceTemp");

			//入力された名前と一致したデータをオブジェクトへ
			DatabaseControll dcl = new DatabaseControll();
			affectedRows = dcl.updateSentence(sentenceName, sentenceMain, sentenceLine,sentenceKind,sentenceTemp,sentenceId);
				
			//成否をメッセージで通知
	        if (affectedRows > 0) {
	        	updataMessage = "変更しました";
				request.setAttribute("alert", updataMessage);
				dispatcher = request.getRequestDispatcher("/updateSentence.jsp");
				dispatcher.forward(request, response);
	        } else {
	        	updataMessage = "変更に失敗しました";
	        	request.setAttribute("alert", updataMessage);
	        	dispatcher = request.getRequestDispatcher("/updateSentence.jsp");
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
