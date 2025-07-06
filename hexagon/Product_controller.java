

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Product_controller
 */
public class Product_controller extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pro_name=request.getParameter("pro_name");
		int pro_price=Integer.parseInt(request.getParameter("pro_price"));
		int pro_count=Integer.parseInt(request.getParameter("pro_count"));
		
		Product p=new Product();
		p.setPro_name(pro_name);
		p.setPro_price(pro_price);
		p.setPro_count(pro_count);
		
		ProductDAO dao=new ProductDAO();
		try {
			dao.insertProduct(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("Product_output.jsp");
	}

}
