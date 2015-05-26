package vantage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class names
 */
@WebServlet("/names")
public class names extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public names() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] names = new String[]{"a1","a2","a3","a4","b1","b2"};
		String param = request.getParameter("searchtext");
		
		
		int names_length=names.length;
		String str_names="";
		for(int i=0;i<names_length;i++){
			if(names[i].contains(param)){
				str_names = str_names +names[i];
				if(i<names_length-1)
					str_names=str_names+",";
			}
			

		}
		if(str_names=="")
			str_names = "NOT FOUND!!!";
		PrintWriter out = response.getWriter();
		
		out.write(str_names);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
