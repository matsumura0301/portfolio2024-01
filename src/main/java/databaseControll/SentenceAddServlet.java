package databaseControll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			String addMessage = null;
			int affectedRows = 0;
			
			//リクエストデータの格納
			String sentenceName = request.getParameter("sentenceName");
			String sentenceMain = request.getParameter("sentenceMain");
			int sentenceLine = Integer.parseInt(request.getParameter("sentenceLine"));
			String sentenceKind = request.getParameter("sentenceKind");
			String sentenceTemp = request.getParameter("sentenceTemp");

			//登録
			DatabaseControll dcl = new DatabaseControll();
			affectedRows = dcl.addSentence(sentenceName,sentenceMain,sentenceLine,sentenceKind,sentenceTemp);
			
			//データの登録に成功した場合
			if(affectedRows > 0) {
				addMessage ="登録しました";
				request.setAttribute("addMessage", addMessage);
				dispatcher = request.getRequestDispatcher("/databaseManagement.jsp");
				dispatcher.forward(request, response);
			//データの登録に失敗した場合
			}else {
				addMessage = "登録に失敗しました";
				request.setAttribute("addMessage", addMessage);
				dispatcher = request.getRequestDispatcher("/databaseManegement.jsp");
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
