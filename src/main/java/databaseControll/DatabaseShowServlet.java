package databaseControll;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class databaseShowServlet
 */
@WebServlet("/DatabaseShowServlet")
public class DatabaseShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseShowServlet() {
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
			
			
			RequestDispatcher dispatcher = null;
			String message = null;
			ArrayList<DatabaseDTO> sentenceDataList = null;
			
			DatabaseControll dcl = new DatabaseControll();
			sentenceDataList = (ArrayList<DatabaseDTO>) dcl.showAllsentence();
			
			if(sentenceDataList != null) {
				request.setAttribute("sentenceDataList", sentenceDataList);
				dispatcher = request.getRequestDispatcher("/showAllSentence.jsp");
				dispatcher.forward(request, response);
			}else {
				message = "データがありません";
				request.setAttribute("alert", message);
				dispatcher = request.getRequestDispatcher("/admin.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
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
