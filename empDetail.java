package vantage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




	/**
	* Servlet implementation class empDetail
	*/
	@WebServlet(name="empDetail",urlPatterns={"/empDetail"})
	public class empDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* @see HttpServlet#HttpServlet()
	*/
	Employee employee;
	
	public empDetail() {
		super();
		// TODO Auto-generated constructor stub
		employee = new Employee("Akshay","20",new String[]{"cricket","football"});
	}
	
	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("age"));
		*/
		
		//we need a json internal array so, making a string corresponding to that format.
		String[] hobbies = employee.getHobbies();
		int hobbies_length=hobbies.length;
		String empHobbies="[";
		for(int i=0;i<hobbies_length;i++){
		
			empHobbies = empHobbies +"{"+'"'+"hobby"+'"'+":"+'"'+hobbies[i]+'"'+"}";
			if(i<hobbies_length-1)
				empHobbies=empHobbies+",";

		}
		empHobbies = empHobbies+"]";
		
		
		response.setContentType("application/json");
		String json = "{"+'"'+"name"+'"'+":"+'"'+employee.getName()+'"'+","
					+'"'+"age"+'"'+":"+'"'+employee.getAge()+'"'+","
					+'"'+"hobbies"+'"'+":"+empHobbies+"}";
		PrintWriter out = response.getWriter();
		out.write(json);
	}
	
	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
		while ((line = reader.readLine()) != null)
			jb.append(line);
		} catch (Exception e) { }
		
		//System.out.println(jb.toString());
		
		//extracting each hobby and putting it into a string array so that we can set Employee.hobbies
		String jbstr = jb.toString();
		int nameindex = jbstr.indexOf("name");
		int ageindex = jbstr.indexOf("age");
		int hobbiesindex = jbstr.indexOf("hobbies");
		
		
		int hobbyindex = jbstr.indexOf("hobby");
		int hashkeyindex = jbstr.indexOf("$$hashKey");
		//System.out.println(hobbyindex);
		//System.out.println(hashkeyindex);
		ArrayList<String> ar = new ArrayList<String>();
		while(hobbyindex!=-1){
			//System.out.println(hobbyindex);
			String hobbystr = jbstr.substring(hobbyindex+8,hashkeyindex-3);
			//System.out.println(hobbystr);
			if(hobbystr.length()>=1)
				ar.add(hobbystr);
			hobbyindex = jbstr.indexOf("hobby",hashkeyindex);
			hashkeyindex = jbstr.indexOf("$$hashKey",hobbyindex);
		}
		String[] hobbiesArr = new String[ar.size()];
		hobbiesArr = ar.toArray(hobbiesArr);
		//System.out.println("hobbies");
		
		//setting Employee
		employee.setName(jbstr.substring(nameindex+7, ageindex-3));
		employee.setAge(jbstr.substring(ageindex+6, hobbiesindex-3));
		employee.setHobbies(hobbiesArr);

		//System.out.println(employee.getName());
		
		String[] hobbies = employee.getHobbies();
		int hobbies_length=hobbies.length;
		String empHobbies="[";
		for(int i=0;i<hobbies_length;i++){
		
			empHobbies = empHobbies +"{"+'"'+"hobby"+'"'+":"+'"'+hobbies[i]+'"'+"}";
			if(i<hobbies_length-1)
				empHobbies=empHobbies+",";
		
		}
		empHobbies = empHobbies+"]";
		
		
		response.setContentType("application/json");
		String json = "{"+'"'+"name"+'"'+":"+'"'+employee.getName()+'"'+","
		+'"'+"age"+'"'+":"+'"'+employee.getAge()+'"'+","
		+'"'+"hobbies"+'"'+":"+empHobbies+"}";
		PrintWriter out = response.getWriter();
		out.write(json);


}

}
