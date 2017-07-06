package dtTest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
/**
 * Servlet implementation class ReturnJSONStub
 */
@WebServlet("/ReturnJSONStub")
public class ReturnJSONStub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnJSONStub() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//sets response type to JSON
		response.setContentType("application/json");
		
		//uses a List of HashMaps for key:value pairs
		List<Map<String, String>> data = new ArrayList<>();
		Map<String, String> map = new HashMap<String, String>();
		
		//replace below loop with your ResultSet
		for(int i=0;i<3;i++){
			map.clear();
			map.put("name", "Ian");
			map.put("test", "test1");
			map.put("number", "1");
			data.add(map);
		}
		
		String json = getJSON(data);
		
		//uses POJO for JSON
		//String json = getJSON();
		
		//returns JSON to html
		PrintWriter out = response.getWriter();
		out.println(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected String getJSON(List<Map<String, String>> data){
		Gson gson = new Gson();
		String json = gson.toJson(data);
		
		return json;
	}
	
	protected String getJSON(){
		SQLPOJO obj = new SQLPOJO("Ian", "test", 1);
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		
		return json;
	}
}
