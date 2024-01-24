//SQL接続メソッドの検証用プログラム

package userControll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConnectTest
 */
@WebServlet("/ConnectTest")
public class ConnectTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		//ここにメソッドを記載
		

		ArrayList<UserDTO> userDatalist = null;
		
		
		UserControll ucl = new UserControll();
		userDatalist = (ArrayList<UserDTO>) ucl.showAllUser();
		
		out.println("<html lang='ja'>");
		out.println("<head>");
		out.println("<title>test</title>");
		out.println("</head>");
		out.println("<body>");
		
		//検証内容を記載する
		
		out.println(userDatalist.size());
		out.println("</body>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
